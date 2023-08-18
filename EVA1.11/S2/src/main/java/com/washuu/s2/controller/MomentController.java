package com.washuu.s2.controller;
import com.washuu.s2.domain.Comment;
import com.washuu.s2.domain.Moment;
import com.washuu.s2.domain.User;
import com.washuu.s2.dto.MomentDTO;
import com.washuu.s2.service.CommentService;
import com.washuu.s2.service.MomentService;
import com.washuu.s2.service.SchoolService;
import com.washuu.s2.service.UserService;
import com.washuu.s2.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class MomentController {

    @Autowired
    private MomentService momentService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/queryCommonMoment")
    @CrossOrigin
    @ResponseBody
    public List<MomentDTO> queryArticles() {
        List<Moment> contents = momentService.query();
        List<MomentDTO> respList = contents.stream().map(item -> {
            Integer uid = item.getUid();
            Integer mid = item.getMid();

            User user = userService.queryUserByUid(uid);
            List<Comment> comments = commentService.getCommentByMid(mid);
            Integer visitCount = item.getVisitCount();
            Double p1 = Math.log10(visitCount) * 4;
            Double p2 = (double)(comments.size() * (item.getCommend() - item.getUnlike()) / 5 );
//            Integer commentNum = comments.size();
            Double cScore = 0.0;
            if(!comments.isEmpty()) {
                cScore = comments.stream().mapToDouble(comment -> {
//                    int diff =comment.getCommend() - comment.getUnlike();
                    return (comment.getCommend() - comment.getUnlike()) ;
                }).sum();//p3
            }
            LocalDateTime localDate0 = DateUtil.getLocalTimeFromString(item.getCreateTime());
            LocalDateTime localDate1 = DateUtil.getLocalTimeFromString(item.getUpdateTime());
            LocalDateTime now = LocalDateTime.now();
            Duration duration1 = Duration.between(localDate0, now);
            Duration duration2 = Duration.between(localDate1, now);
            long mAge = duration1.toHours();
            long mUpdate = duration2.toHours();
            Double p4 = Math.pow(((mAge + mUpdate)/2 + 1), 1.5);
            Double score = (p1 + p2 + cScore) / p4;
            MomentDTO momentDTO = new MomentDTO(item, user, score);
            return momentDTO;
        }).sorted(Comparator.comparing(MomentDTO::getScore).reversed()).collect(Collectors.toList());
        return respList;
    }


    @CrossOrigin
    @PostMapping("publish")
    public String publish(HttpServletRequest httpServletRequest, @RequestBody Moment moment) {
//        moment.setMid(1);
        moment.setCid(1);
        moment.setCreateTime(DateUtil.getDateTime());
        moment.setUpdateTime(DateUtil.getDateTime());
//        HttpSession session = httpServletRequest.getSession();
//        moment.setUid(((User)(session.getAttribute("USER"))).getUid());//这个要从session上面获得用户，然后再查找到用户uid
        moment.setUid(22);//这个要从session上面获得用户，然后再查找到用户uid
        int sign = momentService.publish(moment);
        System.out.println(sign);
        if(sign == 1){
            System.out.println("OK");
            return "OK";
        }
        System.out.println("Failed");
        return "Failed";
    }

    @GetMapping("/queryUserName")
    @ResponseBody
    @CrossOrigin
    public String queryUsername() {
        return null;
    }

}
