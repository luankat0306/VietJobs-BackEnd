package com.springmvc.vietjob.controller;

import com.springmvc.vietjob.exception.ResourceNotFoundException;
import com.springmvc.vietjob.model.Career;
import com.springmvc.vietjob.model.Enterprise;
import com.springmvc.vietjob.model.Job;
import com.springmvc.vietjob.payload.response.MessageResponse;
import com.springmvc.vietjob.repository.CandidateRepository;
import com.springmvc.vietjob.repository.CareerRepository;
import com.springmvc.vietjob.repository.EnterpriseRepository;
import com.springmvc.vietjob.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    JobRepository JobRepository;

    @Autowired
    EnterpriseRepository enterpriseRepository;

    @Autowired
    CandidateRepository candidateRepository;

    @Autowired
    CareerRepository careerRepository;

    // List Jobs
    @GetMapping
    public ResponseEntity<Map<String, Object>> getJobs(@RequestParam("page") int page, @RequestParam("rowPerPage") int rowPerPage) {
        Pageable pageable = PageRequest.of(page, rowPerPage);

        Page<Job> pageJobs = JobRepository.findAll(pageable);

        Map<String, Object> res = new HashMap<>();
        res.put("jobs", pageJobs.getContent());
        res.put("count", pageJobs.getTotalPages());

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/popular")
    public ResponseEntity<Map<String, Object>> getJobsPopular(@RequestParam("page") int page,
                                                              @RequestParam("rowPerPage") int rowPerPage) {
        Pageable pageable = PageRequest.of(page, rowPerPage);

        Page<Job> pageJobs = JobRepository.findAllJobsPopular(pageable);
        Map<String, Object> res = new HashMap<>();
        res.put("jobs", pageJobs.getContent());
        res.put("count", pageJobs.getTotalPages());
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    // List Jobs Of Enterprise
    @GetMapping("/enterprises/{id}")
    public List<Job> getJobsOfEnterprise(@PathVariable Long id) {
        Enterprise nhaTuyenDung = enterpriseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy"));
        return JobRepository.findAllByEnterprise(nhaTuyenDung, Sort.by("startDate").descending());
    }

    // List Jobs Of Career
    @GetMapping("/{jobId}/career/{careerId}")
    public List<Job> getJobsOfCareer(@PathVariable Long jobId, @PathVariable Long careerId) {
        Career career = careerRepository.findById(careerId)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy"));

        return JobRepository.findAllByCareerAndIdNot(career, jobId);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchJob(@RequestParam("keyword") String keyword, @RequestParam("career") String career,
                                       @RequestParam("province") String province, @RequestParam("page") int page, @RequestParam("rowPerPage") int rowPerPage) {

        Pageable pageable = PageRequest.of(page, rowPerPage);

        Page<Job> pageJobs = JobRepository.searchJob(keyword, career, province, pageable);

        if (pageJobs.getTotalElements() == 0) {
            return ResponseEntity.badRequest().body(new MessageResponse("Không tìm thấy"));
        }

        Map<String, Object> res = new HashMap<>();
        res.put("jobs", pageJobs.getContent());
        res.put("count", pageJobs.getTotalPages());

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createJob(@RequestBody Job congViec) {
        LocalDate dateNow = LocalDate.now();

        Date date = java.sql.Date.valueOf(dateNow);

        if (congViec.getEndDate().before(date)) {
            return ResponseEntity.badRequest().body(new MessageResponse("Hạn nộp phải sau ngày hiện tại"));
        }

        congViec.setStartDate(date);
        return ResponseEntity.ok(JobRepository.save(congViec));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJob(@PathVariable Long id) {
        Job congViec = JobRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy id= " + id));
        return ResponseEntity.ok(congViec);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable Long id, @RequestBody Job congViecForm) {
        Job congViec = JobRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy id= " + id));

        congViecForm.setId(congViec.getId());

        Job updatedCongViec = JobRepository.save(congViecForm);
        return ResponseEntity.ok(updatedCongViec);
    }

    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable Long id) {
        Job job = JobRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy id= " + id));

        candidateRepository.deleteAllByJob(job);

        JobRepository.deleteById(id);
        return "Delete Success";
    }

    @GetMapping("/count")
    public long countJob() {
        return JobRepository.count();
    }

    @GetMapping("/list-count-monthly/{year}")
    public List<Long> countJobWithMonth(@PathVariable int year) {
        List<Long> dataList = new ArrayList<>();
        LocalDate dateNow = LocalDate.now();
        int monthInt;

        // Year Present
        if (year == dateNow.getYear()) {
            monthInt = dateNow.getMonthValue();
        }
        // Less Year Present
        else {
            monthInt = 12;
        }

        for (int i = 1; i <= monthInt; i++) {
            dataList.add(JobRepository.countJobByMonthAndYear(i, year));
        }

        return dataList;
    }

    @GetMapping("/list-year")
    public List<Date> getYearly() {
        List<Date> years = new ArrayList<>();
        Date dateNow = new Date(System.currentTimeMillis());

        years.add(dateNow);
        years.addAll(JobRepository.getYears());

        return years;
    }

    @GetMapping("/chart/top-five-jobs")
    public List<Object> topFiveJob() {
        return JobRepository.topFiveJob();
    }

}
