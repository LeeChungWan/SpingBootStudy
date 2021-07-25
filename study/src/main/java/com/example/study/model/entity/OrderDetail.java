package com.example.study.model.entity;


import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // order_detail에 자동 연결
@ToString(exclude = {"orderGroup", "item"})
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true) // chain 형태로 객체 생성가능
//@ToString(exclude = {"user", "item"}) // user와 item은 연관관계로 묶여 서로 호출하기 때문에 exclude를 안해주면 stackoverflow가 발생한다
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private LocalDateTime arrivalDate;

    private Integer quantity;

    private BigDecimal totalPrice;

    @CreatedDate
    private LocalDateTime createdAt;

    /*
     XXXBy로 끝나는 어노테이션은 component 패키지의 LoginUserAuditorAware의 getCurrentAuditor 함수의 리턴 값을 받는다.
     @EntityListeners(AuditingEntityListener.class) 사용 클래스에 어노테이션 해줘야함
     */
    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;

    // OrderDetail N : OrderGroup 1
    @ManyToOne
    private OrderGroup orderGroup;

    // OrderDetail N : Item 1
    @ManyToOne
    private Item item;


}
