package com.example.study.model;

/*


 Lombok 이란?
  생성자와 get, set 메소드까지 자동으로 생성해주는 기능
  사용법 @Data 로 사용
  사용 하기 위해서 maven, gradle에 dependency를 추가해야함

  lombok을 사용했는데 get, set등 사용이 안되면
  file -> setting -> 검색창에 enable annotaion processing 을 체크해야함.
  
  @AllArgsConstructor를 사용하면 모든 변수를 사용하는 생성자를 만들어준다
 */

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchParam {
    private String account;
    private String email;
    private int page;
}
