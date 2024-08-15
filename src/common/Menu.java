package common;

public enum Menu {
  STOCKREQUESTMENUSELECT("1. 입고요청서 작성 | 2. 입고요청서 조회 | 3. 입고요청서 수정 | 4. 입고요청서 삭제 | 5. 나가기"),
  FINDCONDITION("1. 모든 요청서 조회 | 2. 요청서 한 개 조회 | 3. 입고 상태별 조회 | 4. 생성 날짜별 조회 | 5. 물건 ID별 조회 | 6. 입고 예정일별 조회"),
  //유저가 창고일 경우 공급자 ID별 조회도 가능하게 해주기
  STOCKREQUESTCOLUMN("요청서ID\t물건ID\t박스수량\t박스사이즈\t입고상태\t입고예정일\t입고서생성일\t비고");
  private final String description;

  Menu(String description){
    this.description = description;
  }

  public String getDescription(){
    return description;
  }

}
