package test.com.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MemberDAOimpl implements MemberDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public MemberDAOimpl() {
		try {
			Class.forName(MemberDB_postgres.DRIVER_NAME);
			System.out.println("Driver Successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void jdbcConnectionTest() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(MemberDB_postgres.URL, MemberDB_postgres.USER,
					MemberDB_postgres.PASSWORD);
			System.out.println("conn successed...");
			String sql = "select version() as version";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("version"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally
	}

	@Override
	public int insert(MemberVO vo) {
		// 3-1
		System.out.println("insert()...");
		System.out.println(vo);
		// 3-2
		int flag = 0;
		// 3-3
		try {
			// 3-4 getConnection
			conn = DriverManager.getConnection(MemberDB_postgres.URL, MemberDB_postgres.USER,
					MemberDB_postgres.PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(MemberDB_postgres.SQL_INSERT);
			pstmt.setString(1, vo.getNickname());
			pstmt.setString(2, vo.getMember_name());
			pstmt.setString(3, vo.getPassword());
			pstmt.setString(4, vo.getAge());
			pstmt.setString(5, vo.getHandy());
			pstmt.setString(6, vo.getLocation());
			pstmt.setString(7, vo.getGender());

			// 3-6
			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally
		return flag;
	}

	@Override
	public int update(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MemberVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO idCheck(MemberVO vo) {
		System.out.println("idCheck()...");
		MemberVO vo2 = null;

		try {
			conn = DriverManager.getConnection(MemberDB_postgres.URL, MemberDB_postgres.USER,
					MemberDB_postgres.PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(MemberDB_postgres.SQL_ID_CHECK);
			pstmt.setString(1, vo.getMember_name());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo2 = new MemberVO();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally

		return vo2;
	}

	@Override
	public MemberVO nickNameCheck(MemberVO vo) {
		MemberVO vo2 = null;

		try {
			conn = DriverManager.getConnection(MemberDB_postgres.URL, MemberDB_postgres.USER,
					MemberDB_postgres.PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(MemberDB_postgres.SQL_NICK_CHECK);
			pstmt.setString(1, vo.getNickname());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo2 = new MemberVO();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally

		return vo2;
	}

	@Override
	public MemberVO login(MemberVO vo) {
		MemberVO vo2 = new MemberVO();

		try {
			conn = DriverManager.getConnection(MemberDB_postgres.URL, MemberDB_postgres.USER,
					MemberDB_postgres.PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(MemberDB_postgres.SQL_LOGIN);
			pstmt.setString(1, vo.getMember_name());
			pstmt.setString(2, vo.getPassword());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo2 = new MemberVO();
				vo2.setMember_name(null);
				vo2.setPassword(rs.getString("password"));
				vo2.setNickname(rs.getString("nickname"));
				vo2.setAge(rs.getString("age"));
				vo2.setHandy(rs.getString("handy"));
				vo2.setLocation(rs.getString("location"));
				vo2.setGender(rs.getString("gender"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally

		return vo2;
	
	}

}
	



