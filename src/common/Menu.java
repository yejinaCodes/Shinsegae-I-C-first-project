package common;

public enum Menu {
  STOCKREQUESTMENUSELECT("1. 입고요청서 작성 | 2. 입고요청서 조회 | 3. 입고요청서 수정 | 4. 입고요청서 삭제 | 5. 나가기");
  private final String description;

  Menu(String description){
    this.description = description;
  }

  public String getDescription(){
    return description;
  }

}
