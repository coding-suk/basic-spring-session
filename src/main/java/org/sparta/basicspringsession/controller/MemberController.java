package org.sparta.basicspringsession.controller;

import lombok.RequiredArgsConstructor;
import org.sparta.basicspringsession.dto.MemberSaveRequestDto;
import org.sparta.basicspringsession.dto.MemberSaveResponseDto;
import org.sparta.basicspringsession.dto.MemberSimpleResponseDto;
import org.sparta.basicspringsession.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<MemberSaveResponseDto> saveMember(@RequestBody MemberSaveRequestDto requestDto) {
        return ResponseEntity.ok(memberService.saveMember(requestDto));
    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberSimpleResponseDto>> getMember() {
        return ResponseEntity.ok(memberService.getMembers());
    }
}
