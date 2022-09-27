package test.com.utils;

public interface DB_oracle {
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "kosta";
	String PASSWORD = "hi123456";

	// 멤버 (회원)
	String SQL_LOGIN = "select * from member where member_name=? and password=?";

	// 모임
	// member_id 컬럼은 일단
	String MEETING_INSERT = "insert into "
			+ "meeting (meeting_id,name,explanation,gender,age,location,permission,secret,total_people,image_url,member_id) "
			+ "values(?,?,?,?,?,?,?,?,?,?,?)";
	String MEETING_SEARCH_LIST_NAME = "select name from meeting where name like ?";
	String MEETING_SELECT_ALL = "select * from meeting";
	String MEETING_SELECT_ONE = "select * from meeting where meeting_id = ?";
	String MEETING_ENTER = "insert into " 
			+"meeting_user (meeting_user_id,meeting_id,member_id,role) "
			+"values(seq_meeting_user.nextval,?,?,?)";
	String MEETING_ID = "select seq_meeting.nextval from dual";
	String MEETING_UPDATE = "update meeting set name = ?,explanation = ?, gender = ?,age=?,location = ?,permission = ? ,secret = ? ,total_people = ?,image_url = ? where meeting_id = ?";
	String MEETING_DISTINGUISH = "select count(role) from meeting_user where meeting_id = ? and member_id = ?";

	// 라운드
	String ROUND_INSERT = "insert into " + "round (round_id,name,course,total_people,round_date,image_url) "
			+ "values(?,?,?,?,?,?)";
	String ROUND_SEARCH_LIST_NAME = "select name from round where name like ?";
	String ROUND_SELECT_ALL = "select * from round";
	String ROUND_SELECT_ONE = "select * from round where round_id = ?";
	String ROUND_ENTER = "insert into " 
						+"round_user (round_user_id,round_id,member_id,role) "
						+"values(seq_round_user.nextval,?,?,?)";
	String ROUND_ID = "select seq_round.nextval from dual";
	// 라운드 가입유무 구별 쿼리
	String ROUND_DISTINGUISH = "select count(role) from round_user where round_id = ? and member_id = ?";

	
	// 액티비티
	String MEETING_ACTIVITY_SELECT_ALL = "select * from activity where meeting_id = ?";

	// notice(알림)
	String SQL_SELECT_ALL = "select * from notice order by notice_id desc";
	String SQL_DELETE = "delete from notice order by notice_id desc";

	// main (메인페이지)
		String SQL_MY_MEETING_SELECT_ALL = "select meeting.meeting_id, name, explanation, image_url "
				+ "from meeting join meeting_user on meeting.meeting_id = meeting_user.meeting_id "
				+ "where meeting_user.member_id=?";
		String SQL_MY_ACTIVITY_SELECT_ALL = "select activity.activity_id,name,activity_date,activity_time,location, "
				+ "(select count(*)from activity_user where activity_user.activity_id = activity.activity_id) current_people, "
				+ "image_url, total_people from activity join activity_user "
				+ "on activity.activity_id = activity_user.activity_id " + "where activity_user.member_id=?";
		String SQL_MY_ROUND_SELECT_ALL = "select round.round_id,name,course,round_date,(select count(*)from round_user where round_user.round_id = round.round_id) current_people, total_people, image_url from round join round_user on round.round_id = round_user.round_id where round_user.member_id=?";
		String SQL_ACTIVITY_SELECT_ALL = "select activity.activity_id,name,activity_date,activity_time,location, "
				+ "(select count(*)from activity_user where activity_user.activity_id = activity.activity_id) current_people, "
				+ "image_url, total_people from activity join activityUser "
				+ "on activity.activity_id = activity_user.activity_id order by activity_id desc";
		String SQL_RECOMMEND_ACTIVITY_AGE_SELECT_ALL = "select distinct activity_id,name,activity_date,activity_time,activity_location,current_people,image_url,total_people from recommend_activity_view "
				+ "where meeting_age like (select age from member where member_id=?) and secret like 'false' and member_id !=? " 
				+ "and current_people<total_people";
		String SQL_RECOMMEND_ACTIVITY_HANDY_SELECT_ALL = "select distinct activity_id,name,activity_date,activity_time,activity_location,current_people,image_url,total_people from recommend_activity_view "
				+ "where meeting_handy like (select handy from member where member_id=?) and secret like 'false' and member_id !=? "
				+ "and current_people<total_people";
		String SQL_RECOMMEND_ACTIVITY_GENDER_SELECT_ALL = "select distinct activity_id,name,activity_date,activity_time,activity_location,current_people,image_url,total_people from recommend_activity_view "
				+ "where meeting_gender like (select gender from member where member_id=?) and secret like 'false' and member_id != ? "
				+ "and current_people<total_people";
		String SQL_RECOMMEND_ACTIVITY_LOCATION_SELECT_ALL = "select distinct activity_id,name,activity_date,activity_time,activity_location,current_people,image_url,total_people from recommend_activity_view "
				+ "where activity_location like (select location from member where member_id=?) and secret like 'false' and member_id != ? "
				+ "and current_people<total_people";
		String SQL_IMMINENT_ACTIVITY_SELECT_ALL = "select distinct activity_id,name,activity_date,activity_time,activity_location,current_people,image_url,total_people, "
				+ "(TO_DATE(activity_date, 'YYYY-MM-DD') - TO_DATE(TO_CHAR(SYSDATE,'YYYY-MM-DD'))) d_day "
				+ "from recommend_activity_view "
				+ "where secret like 'false' and member_id !=? and current_people<total_people";
}