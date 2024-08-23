package org.sparta.basicspringsession.service;

import lombok.RequiredArgsConstructor;
import org.sparta.basicspringsession.dto.MemberSaveRequestDto;
import org.sparta.basicspringsession.dto.MemberSaveResponseDto;
import org.sparta.basicspringsession.dto.MemberSimpleResponseDto;
import org.sparta.basicspringsession.entity.Member;
import org.sparta.basicspringsession.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberSaveResponseDto saveMember(MemberSaveRequestDto memberSaveRequestDto) {
        Member newMember = new Member(memberSaveRequestDto.getName());
        Member saveMember = memberRepository.save(newMember);

        return new MemberSaveResponseDto(saveMember.getName());
    }

    public List<MemberSimpleResponseDto> getMembers() {
        List<Member> members = memberRepository.findAll();

        List<MemberSimpleResponseDto> memberSimpleResponseDtos = new ArrayList<>();
        for (Member member : members) {
            memberSimpleResponseDtos.add(new MemberSimpleResponseDto(member.getId(), member.getName()));
        }
        return memberSimpleResponseDtos;
    }

}
