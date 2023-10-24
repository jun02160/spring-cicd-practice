package com.example.seminar.domain;

import com.example.seminar.repository.MemberJpaRepository;
import com.example.seminar.repository.PostJpaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@SpringBootTest
@Profile("test")
public class MemberEntityTest {

    @Autowired
    MemberJpaRepository memberJpaRepository;

    @Autowired
    PostJpaRepository postJpaRepository;

    @Test
    @DisplayName("MemberEntity 생성 테스트")
    @Transactional
    public void Post조회_Member() {

        Member member = Member.builder()
                .name("홍길동")
                .nickname("hong")
                .age(25)
                .sopt(new SOPT(33, Part.SERVER))
                .build();

        Member savedMember = memberJpaRepository.save(member);

        for (int i = 0; i < 1000; i++) {
            postJpaRepository.save(Post.builder()
                    .member(savedMember)
                    .title("제목")
                    .content("내용")
                    .build());
        }

        // Start Time
        long start = System.currentTimeMillis();
        // List<Post> posts = postJpaRepository.findAllByMember(member);
        List<Post> posts = postJpaRepository.findAllByMemberId(member.getId());
        System.out.println("posts.size() = " + posts.size());
        // End Time
        long end = System.currentTimeMillis();
        System.out.println("Member Id로 조회 걸린 시간 : " + (end - start) + "ms");
    }
//
//    @Test
//    @DisplayName("MemberEntity 생성 테스트")
//    @Transactional
//    public void Post조회_Member_Id() {
//        Member member = Member.builder()
//                .name("홍길동")
//                .nickname("hong")
//                .age(25)
//                .sopt(new SOPT(33, Part.SERVER))
//                .build();
//        Member savedMember = memberJpaRepository.save(member);
//
//        for (int i = 0; i < 1000; i++) {
//            postJpaRepository.save(Post.builder()
//                    .member(savedMember)
//                    .title("제목")
//                    .content("내용")
//                    .build());
//        }
//
//        long start = System.currentTimeMillis();
//        Member findMember = memberJpaRepository.findByIdOrThrow(savedMember.getId());
//        List<Post> posts = postJpaRepository.findAllByMember(findMember);
//        System.out.println("posts.size() = " + posts.size());
//        long end = System.currentTimeMillis();
//        System.out.println("Member 조회 후에 Member로 findAll 조회 걸린 시간 : " + (end - start) + "ms");
//    }
//




}
