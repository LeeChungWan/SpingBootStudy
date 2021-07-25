package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import com.example.study.model.enumclass.UserStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public class UserRepositoryTest extends StudyApplicationTests {

    /*
     @Autuwired 를 하면 DI(Dependency Injection 의존성 주입을 하는것으로 개발자가 직접 객체를 만들지 않고
     스프링 프레임이 객체를 관리하는 것
     UserRepository userRepository = new UserRepository(); // 개발자가 객체 생성
     Singleton pattern 이 적용됨.
     */
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {
        /*
        // String sql = insert into user (%s, %s, %d) value (account, email, age);
        User user = new User();
        //user.setId(); DB 에서 AI 로 생성되므로 개발자가 지정하면 안됨
        user.setAccount("TestUser06");
        user.setEmail("TestUser03@gmail.com");
        user.setPhoneNumber("010-6666-6666");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("TestUser06");

        // save 를 통해 DB에 저장되며, DB에 저장된 새로운 User 가 반환되어 나옴.
        User newUser = userRepository.save(user);
        System.out.println("newUser" + newUser);
         */

        String account = "Test03";
        String password = "admin1234";
        UserStatus status = UserStatus.REGISTERED;
        String email = "Test01@gmail.com";
        String phoneNumber = "010-3333-3333";
        LocalDateTime registeredAt = LocalDateTime.now();
//        LocalDateTime createdAt = LocalDateTime.now();
//        String createdBy = "AdminServer";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
//        user.setCreatedAt(createdAt);
//        user.setCreatedBy(createdBy);
        
        User u = User.builder()
                .account(account)
                .password(password)
                .email(email)
                .status(status)
                .build();

        User newUser = userRepository.save(user);
        Assertions.assertNotNull(newUser);

    }

    @Test
    @Transactional
    public void read() {
        /*
         Optional 공부하기.
         있을수도 있고 없을 수도 있다.


        // select * from user where id = ?
        Optional<User> user = userRepository.findByAccount("TestUser06");

        // ifPresent 를 통해 있을때만 코드를 실행
        user.ifPresent(selectUser ->{

            selectUser.getOrderDetailList().stream().forEach(orderDetail -> {
                Item item = orderDetail.getItem();
                System.out.println("Item: " + item);
                System.out.println("User: " + orderDetail.getUser());
            });

        });
        */

        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-1111");
        
        // @Accessors(chain = true) // chain 형태로 객체 생성가능 엔티티에서 해당 어노테이션 쓰면 체인 가능
//        user.setEmail().setPhoneNumber().setStatus();

        if(user !=null) {
            user.getOrderGroupList().stream().forEach(orderGroup -> {
                System.out.println("----------------주문묶음---------------");
                System.out.println("수령인 : " + orderGroup.getRevName());
                System.out.println("총금액 : " + orderGroup.getTotalPrice());
                System.out.println("총수량 : " + orderGroup.getTotalQuantity());
                System.out.println("수령지 : " + orderGroup.getRevAddress());

                System.out.println("----------------주문상세---------------");
                orderGroup.getOrderDetailList().forEach(orderDetail -> {
                    System.out.println("파트너사 : " + orderDetail.getItem().getPartner().getName());
                    System.out.println("파트너사 카테고리 : " + orderDetail.getItem().getPartner().getCategory().getTitle());
                    System.out.println("주문상품 : " + orderDetail.getItem().getName());
                    System.out.println("고객센터 번호 : " + orderDetail.getItem().getPartner().getCallCenter());
                    System.out.println("주문의 상태 : " + orderDetail.getStatus());
                    System.out.println("도착예정일자 : " + orderDetail.getArrivalDate());
                });
            });
        }

        Assertions.assertNotNull(user);

    }

    @Test
    public void update() {
        /*
        Optional<User> user = userRepository.findById(6L);

        // ifPresent 를 통해 있을때만 코드를 실행
        user.ifPresent(selectUser ->{
            selectUser.setAccount("PPPP");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setCreatedBy("update method()");

            // findById의 6L을 통해 특정 객체 즉, update 할 객체를 찾아서 적용해줌
            userRepository.save(selectUser);
        });

         */
    }

    /*
     @Transactional 을 하면 실제 DB에 반영되지 않는다.
     */
    @Test
    @Transactional
    public void delete() {
        /*
        Optional<User> user = userRepository.findById(2L);

        Assertions.assertTrue(user.isPresent()); // 반드시 True 이어야함

        user.ifPresent(selectUser->{
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(2L);

        Assertions.assertFalse(deleteUser.isPresent());

         */
    }
}
