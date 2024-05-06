# Weather-Diary
. 최종 구현 API 리스트
✅ POST / create / diary
- date parameter 로 받아오기. (date 형식 : yyyy-MM-dd)
- text parameter 로 일기 글을 받아오기.
- 외부 API 에서 받아온 날씨 데이터와 함께 DB에 저장.

✅ GET / read / diary
- date parameter 로 조회할 날짜를 받아오기.
- 해당 날짜의 일기를 List 형태로 반환하기.

✅ GET / read / diaries
- startDate, endDate parameter 로 조회할 날짜 기간의 시작일/종료일을 받아오기.
- 해당 기간의 일기를 List 형태로 반환하기.

✅ PUT / update / diary
- date parameter 로 수정할 날짜를 받아오기.
- text parameter 로 수정할 새 일기 글을 받기.
- 해당 날짜의 첫번째 일기 글을 새로 받아온 일기글로 수정하기.

✅ DELETE / delete / diary
- date parameter 로 삭제할 날짜를 받아오기.
- 해당 날짜의 모든 일기를 지우기.
