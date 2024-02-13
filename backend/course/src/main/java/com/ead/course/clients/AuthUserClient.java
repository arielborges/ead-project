package com.ead.course.clients;

import com.ead.course.dtos.CourseUserDto;
import com.ead.course.dtos.ResponsePageDto;
import com.ead.course.dtos.UserDto;
import com.ead.course.service.UtilsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Log4j2
@Component
public class AuthUserClient {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UtilsService utilsService;

    public Page<UserDto> getAllUsersByCourse(UUID courseId, Pageable pageable){
        List<UserDto> searchResult = null;
        ResponseEntity<ResponsePageDto<UserDto>> result = null;
        String url = utilsService.urlAllUserByCourse(courseId, pageable);
        log.debug("Request url: {}",url);
        log.info("Request url: {}",url);
        try {
            ParameterizedTypeReference<ResponsePageDto<UserDto>> responseType = new ParameterizedTypeReference<ResponsePageDto<UserDto>>() {};
            result = restTemplate.exchange(url, HttpMethod.GET, null, responseType);
            searchResult = result.getBody().getContent();
            log.debug("Response number of elements {}", searchResult.size());
        } catch (Exception e){
            log.error("Error request /users {}",e);
        }
        log.info("Ending request /users courseId {}",courseId);
        return result.getBody();
    }

    public ResponseEntity<UserDto> getOneUserById(UUID userId){
        String url = utilsService.urlOneUserById(userId);
        return restTemplate.exchange(url,HttpMethod.GET,null, UserDto.class);
    }

    public void postSubscriptionuserInCourse(UUID courseId, UUID userId) {
        String url = utilsService.urlPostSubscription(userId);
        var couseUserDto = new CourseUserDto();
        couseUserDto.setUserId(userId);
        couseUserDto.setCourseId(courseId);
        restTemplate.postForObject(url, couseUserDto, String.class);
    }

    public void deleteCourseInAuthuser(UUID courseId){
        String url = utilsService.urlDeleteCourseInAuthuser(courseId);
        restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);
    }
}
