package com.jojoIdu.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPA Entity들이 아래 클래스를 상속할 경우, 클래스 내 필드들도 Column으로 인식하도록 함. (상속한 클래스: Posts)
@EntityListeners(AuditingEntityListener.class) // 아래 클래스에 Auditing 기능을 포함. https://webcoding-start.tistory.com/53
public class BaseTimeEntity { //모든 Entity의 상위 클래스가 되어 Entity들의 modifiedDate, CreatedDate를 관리하는 클래스

    @CreatedDate // 생성 시간 자동 저장.
    private LocalDateTime createdDate;

    @LastModifiedDate // 마지막 수정 시간 자동 저장.
    private LocalDateTime modifiedDate;
}
