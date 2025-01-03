package com.springmvc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.springmvc.domain.club;
import com.springmvc.domain.clubMember;
import com.springmvc.domain.clubboard;
import com.springmvc.domain.clubboardcomment;
import com.springmvc.domain.comment;

@Repository
public class clubRepositoryImpl implements clubRepository 
{

	Connection conn=null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt2 = null;
	ResultSet rs =null;
	ResultSet rs2 =null;
	// club C
	@Override
	public club addClub(club club) {
		String sql = "INSERT INTO club (clubLeader, clubName, clubDescription, clubCategory, region, district) VALUES (?, ?, ?, ?, ?, ?)";
		String sqlSelect = "SELECT * FROM club WHERE clubName = ? AND clubLeader = ?";
		
		try {
			
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, club.getClubLeader());
			pstmt.setString(2, club.getClubName());
            pstmt.setString(3, club.getClubDescription()); 
            pstmt.setString(4, club.getClubCategory()); 
            pstmt.setString(5, club.getRegion());
            pstmt.setString(6, club.getDistrict());
			
            pstmt.executeUpdate();
            System.out.println("클럽 등록 성공");
			
            pstmt = conn.prepareStatement(sqlSelect);
            pstmt.setString(1, club.getClubName()); // 클럽 이름
            pstmt.setString(2, club.getClubLeader()); // 클럽 리더
            rs = pstmt.executeQuery();
            if (rs.next()) {
                club.setClubNum(rs.getInt("clubNum"));
                System.out.println("등록된 클럽 번호: " + club.getClubNum());
            } else {
                System.out.println("클럽 정보를 찾을 수 없습니다.");
            }
            
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("클럽 추가 중 오류 발생"+e.getMessage());
		}
		return club;
	}
	// club R by num
	@Override
	public club getClubByNum(int clubNum) {
		
		club club = null;
		String sql = "SELECT * FROM club WHERE clubNum = ?";
		
		try {
			System.out.print("DB 연결중");
			conn = DBConnection.getConnection();
			System.out.println("DB 연결 성공" + (conn!=null));
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, clubNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				club = new club();
				club.setClubNum(rs.getInt("clubNum"));
		        club.setClubLeader(rs.getString("clubLeader"));
		        club.setClubName(rs.getString("clubName"));
		        club.setClubDescription(rs.getString("clubDescription"));
		        club.setClubCategory(rs.getString("clubCategory"));
		        club.setRegion(rs.getString("region"));
		        club.setDistrict(rs.getString("district"));
		        club.setCount(rs.getInt("memberCount"));
			} else {
				System.out.println("클럽 번호에 해당하는 데이터가 없음" + clubNum);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return club;
	}
	// club update
	@Override
	public void updateClub(club club) {
		String sql = "UPDATE club SET clubLeader = ?, clubName = ?, clubDescription = ?, clubCategory = ? WHERE clubNum = ?";
		
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			
	        pstmt.setString(1, club.getClubLeader());
	        pstmt.setString(2, club.getClubName());
	        pstmt.setString(3, club.getClubDescription());
	        pstmt.setString(4, club.getClubCategory());
	        pstmt.setInt(5, club.getClubNum());
			
	        pstmt.executeUpdate();
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// club delete
	@Override
	public void deleteClub(int clubNum) {
		String sql = "DELETE FROM club WHERE clubNum =?";
		
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, clubNum);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// club Read
	// All read
	@Override
	public List<club> getAllClubs() {
		List<club> clubList = new ArrayList<club>();
		String sql = "SELECT * FROM club";
		
		try {
			
	        conn = DBConnection.getConnection(); // DB 연결
	        pstmt = conn.prepareStatement(sql); // PreparedStatement 생성
	        rs = pstmt.executeQuery(); // 쿼리 실행 및 ResultSet 초기화
			
			while(rs.next()) {
				club club = new club();
				club.setClubLeader(rs.getString("clubLeader"));
				club.setClubNum(rs.getInt("clubNum"));
				club.setClubName(rs.getString("clubName"));
	            club.setClubDescription(rs.getString("clubDescription"));
	            club.setClubCategory(rs.getString("clubCategory"));
	            club.setRegion(rs.getString("region"));
		        club.setDistrict(rs.getString("district"));
		        club.setCount(rs.getInt("memberCount"));
	            clubList.add(club);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return clubList;
	}
	// club category read
	@Override
	public List<club> getClubsByCategory(String category) {
		List<club> clubList = new ArrayList<club>();
		String sql = "SELECT * FROM club where clubCategory = ?";
		try {
	        conn = DBConnection.getConnection(); // DB 연결
	        pstmt = conn.prepareStatement(sql); // PreparedStatement 생성
	        pstmt.setString(1,category);
	        rs = pstmt.executeQuery(); // 쿼리 실행 및 ResultSet 초기화
			
			while(rs.next()) {
				club club = new club();
				club.setClubLeader(rs.getString("clubLeader"));
				club.setClubNum(rs.getInt("clubNum"));
				club.setClubName(rs.getString("clubName"));
	            club.setClubDescription(rs.getString("clubDescription"));
	            club.setClubCategory(rs.getString("clubCategory"));
	            club.setRegion(rs.getString("region"));
		        club.setDistrict(rs.getString("district"));
		        club.setCount(rs.getInt("memberCount"));
	            clubList.add(club);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return clubList;
	}
	// club search read
	@Override
	public List<club> searchClubs(String searchType, String query) {
	    List<club> clubList = new ArrayList<club>();
	    System.out.println("서치타입"+searchType);
	    System.out.println("내용" +query);
	    // searchType에 따른 SQL 쿼리 작성
	    String sql = "";
	    if ("clubName".equals(searchType)) {
	    	System.out.println("클럽네임");
	        sql = "SELECT * FROM club WHERE clubName LIKE ?";
	    } else if ("clubDescription".equals(searchType)) {
	    	System.out.println("클럽설명");
	        sql = "SELECT * FROM club WHERE clubDescription LIKE ?";
	    } else {
	        return clubList; // 잘못된 검색 타입인 경우 빈 리스트 반환
	    }

	    try {
	        conn = DBConnection.getConnection(); // DB 연결
	        pstmt = conn.prepareStatement(sql); // PreparedStatement 생성

	        // 검색어에 '%'를 추가하여 포함된 문자열 검색
	        pstmt.setString(1, "%" + query + "%");
	        
	        rs = pstmt.executeQuery(); // 쿼리 실행 및 ResultSet 초기화

	        while (rs.next()) {
	            club club = new club();
	            club.setClubLeader(rs.getString("clubLeader"));
	            club.setClubNum(rs.getInt("clubNum"));
	            club.setClubName(rs.getString("clubName"));
	            club.setClubDescription(rs.getString("clubDescription"));
	            club.setClubCategory(rs.getString("clubCategory"));
	            club.setRegion(rs.getString("region"));
		        club.setDistrict(rs.getString("district"));
		        club.setCount(rs.getInt("memberCount"));
	            clubList.add(club);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return clubList;
	}
	// club region read
	@Override
	public List<club> getClubsByRegion(String region) {
		List<club> clubList = new ArrayList<club>();
		String sql = "SELECT * FROM club where region = ?";
		try {
	        conn = DBConnection.getConnection(); // DB 연결
	        pstmt = conn.prepareStatement(sql); // PreparedStatement 생성
	        pstmt.setString(1,region);
	        rs = pstmt.executeQuery(); // 쿼리 실행 및 ResultSet 초기화
			
			while(rs.next()) {
				club club = new club();
				club.setClubLeader(rs.getString("clubLeader"));
				club.setClubNum(rs.getInt("clubNum"));
				club.setClubName(rs.getString("clubName"));
	            club.setClubDescription(rs.getString("clubDescription"));
	            club.setClubCategory(rs.getString("clubCategory"));
	            club.setRegion(rs.getString("region"));
		        club.setDistrict(rs.getString("district"));
		        club.setCount(rs.getInt("memberCount"));
	            clubList.add(club);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return clubList;
	}
	// club r category search
	@Override
	public List<club> searchClubsInCategory(String category, String searchType, String query) {
	    List<club> clubList = new ArrayList<club>();
	    String sql = "";

	    // searchType에 따른 SQL 쿼리 작성
	    if ("clubName".equals(searchType)) {
	        sql = "SELECT * FROM club WHERE clubCategory = ? AND clubName LIKE ?";
	    } else if ("clubDescription".equals(searchType)) {
	        sql = "SELECT * FROM club WHERE clubCategory = ? AND clubDescription LIKE ?";
	    } else {
	        return clubList; // 잘못된 검색 타입인 경우 빈 리스트 반환
	    }

	    try {
	        conn = DBConnection.getConnection(); // DB 연결
	        pstmt = conn.prepareStatement(sql); // PreparedStatement 생성

	        // 카테고리와 검색어에 '%'를 추가하여 포함된 문자열 검색
	        pstmt.setString(1, category);
	        pstmt.setString(2, "%" + query + "%");

	        rs = pstmt.executeQuery(); // 쿼리 실행 및 ResultSet 초기화

	        while (rs.next()) {
	            club club = new club();
	            club.setClubLeader(rs.getString("clubLeader"));
	            club.setClubNum(rs.getInt("clubNum"));
	            club.setClubName(rs.getString("clubName"));
	            club.setClubDescription(rs.getString("clubDescription"));
	            club.setClubCategory(rs.getString("clubCategory"));
	            club.setRegion(rs.getString("region"));
	            club.setDistrict(rs.getString("district"));
	            club.setCount(rs.getInt("memberCount"));
	            clubList.add(club);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return clubList;
	}

	// club r region search
	@Override
	public List<club> searchClubsInRegion(String region, String searchType, String query) {
	    List<club> clubList = new ArrayList<club>();
	    String sql = "";

	    // searchType에 따른 SQL 쿼리 작성
	    if ("clubName".equals(searchType)) {
	        sql = "SELECT * FROM club WHERE region = ? AND clubName LIKE ?";
	    } else if ("clubDescription".equals(searchType)) {
	        sql = "SELECT * FROM club WHERE region = ? AND clubDescription LIKE ?";
	    } else {
	        return clubList; // 잘못된 검색 타입인 경우 빈 리스트 반환
	    }

	    try {
	        conn = DBConnection.getConnection(); // DB 연결
	        pstmt = conn.prepareStatement(sql); // PreparedStatement 생성

	        // 지역과 검색어에 '%'를 추가하여 포함된 문자열 검색
	        pstmt.setString(1, region);
	        pstmt.setString(2, "%" + query + "%");

	        rs = pstmt.executeQuery(); // 쿼리 실행 및 ResultSet 초기화

	        while (rs.next()) {
	            club club = new club();
	            club.setClubLeader(rs.getString("clubLeader"));
	            club.setClubNum(rs.getInt("clubNum"));
	            club.setClubName(rs.getString("clubName"));
	            club.setClubDescription(rs.getString("clubDescription"));
	            club.setClubCategory(rs.getString("clubCategory"));
	            club.setRegion(rs.getString("region"));
	            club.setDistrict(rs.getString("district"));
	            club.setCount(rs.getInt("memberCount"));
	            clubList.add(club);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return clubList;
	}
	// clubmember join 시 멤버 수 증가
	@Override
	public void plusmemberCount(int clubNum) {
		String sql = "UPDATE club SET memberCount = memberCount + 1 WHERE clubNum = ?";
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, clubNum);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	// ClubMember C
	@Override
	public void addClubMember(clubMember clubmember) {
	    String sql = "INSERT INTO clubMember(memberId, clubNum, clubName, joinDate, memberphone, memberemail) VALUES (?, ?, ?, ?, ?, ?)";
	    try {
	        conn = DBConnection.getConnection();
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, clubmember.getMemberId());
	        pstmt.setInt(2, clubmember.getClubNum());
	        pstmt.setString(3, clubmember.getClubName());
	        pstmt.setString(4, clubmember.getJoinDate());
	        pstmt.setString(5, clubmember.getMemberphone());
	        pstmt.setString(6, clubmember.getMemberemail());
	        pstmt.executeUpdate();
	    } catch (Exception e) {
	            e.printStackTrace(); // 다른 예외는 일반적인 에러 처리
	        
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
	// ClubMember C
		@Override
		public void addClubLeader(clubMember clubmember) {
		    String sql = "INSERT INTO clubMember(memberId, clubNum, clubName, joinDate, memberphone, memberemail, memberjoin) VALUES (?, ?, ?, ?, ?, ?,?)";
		    try {
		        conn = DBConnection.getConnection();
		        pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1, clubmember.getMemberId());
		        pstmt.setInt(2, clubmember.getClubNum());
		        pstmt.setString(3, clubmember.getClubName());
		        pstmt.setString(4, clubmember.getJoinDate());
		        pstmt.setString(5, clubmember.getMemberphone());
		        pstmt.setString(6, clubmember.getMemberemail());
		        pstmt.setInt(7, 1);
		        pstmt.executeUpdate();
		    } catch (Exception e) {
		            e.printStackTrace(); // 다른 예외는 일반적인 에러 처리
		        
		    } finally {
		        try {
		            if (rs != null) rs.close();
		            if (pstmt != null) pstmt.close();
		            if (conn != null) conn.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		}
	// clubmember join check
	@Override
	public boolean isMemberOfClub(String id, int clubNum) {
	    String sql = "SELECT COUNT(*) FROM clubMember WHERE memberId = ? AND clubNum = ?";
	    boolean isMember = false; // 기본값은 false

	    try {
	        conn = DBConnection.getConnection();
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, id);
	        pstmt.setInt(2, clubNum);
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            int count = rs.getInt(1);
	            isMember = count > 0; // count가 0보다 크면 가입된 상태
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); // 예외 발생 시 스택 트레이스를 출력
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    return isMember;
	}
	@Override
	public Map<String, List<club>> getAllmyClubs(String memberId) {
	    System.out.println("getAllmyClubs");
	    List<club> joinedClubs = new ArrayList<>();  // memberJoin이 1인 클럽
	    List<club> notJoinedClubs = new ArrayList<>(); // memberJoin이 0인 클럽
	    String sqlSelectClubNum = "SELECT clubNum, memberJoin FROM clubmember WHERE memberId = ?";
	    String sqlSelectClub = "SELECT * FROM club WHERE clubNum = ?";    

	    try {
	        conn = DBConnection.getConnection();
	        pstmt = conn.prepareStatement(sqlSelectClubNum);
	        pstmt.setString(1, memberId);
	        rs = pstmt.executeQuery();
	        
	        while (rs.next()) {
	            int clubNum = rs.getInt("clubNum");
	            int memberJoin = rs.getInt("memberJoin"); // memberJoin 값 조회
	            System.out.println("getAllmyClubs, clubNum: " + clubNum + ", memberJoin: " + memberJoin);
	            
	            // 클럽 정보 조회
	            pstmt2 = conn.prepareStatement(sqlSelectClub);
	            pstmt2.setInt(1, clubNum);
	            rs2 = pstmt2.executeQuery();
	            
	            if (rs2.next()) { // 클럽 정보가 존재하는 경우에만
	                club club = new club();
	                club.setClubLeader(rs2.getString("clubLeader"));
	                club.setClubNum(rs2.getInt("clubNum"));
	                club.setClubName(rs2.getString("clubName"));
	                club.setClubDescription(rs2.getString("clubDescription"));
	                club.setClubCategory(rs2.getString("clubCategory"));
	                club.setRegion(rs2.getString("region")); 
	                club.setDistrict(rs2.getString("district"));
	                club.setCount(rs2.getInt("memberCount"));

	                // memberJoin에 따라 리스트에 추가
	                if (memberJoin == 1) {
	                    joinedClubs.add(club); // memberJoin이 1인 경우
	                } else {
	                    notJoinedClubs.add(club); // memberJoin이 0인 경우
	                }
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    // 결과를 Map으로 반환
	    Map<String, List<club>> result = new HashMap<>();
	    result.put("joinedClubs", joinedClubs);
	    result.put("notJoinedClubs", notJoinedClubs);
	    return result;
	}


	// Club 멤버 조회
	@Override
	public List<clubMember> getAllClubMember(int clubNum) {
		List<clubMember> clubMembers = new ArrayList<>();
	    String sql = "SELECT * FROM clubMember WHERE clubNum = ?";
	    try (Connection conn = DBConnection.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql)) {
	           
	           // 클럽 번호 설정
	           pstmt.setInt(1, clubNum);

	           // 쿼리 실행
	           try (ResultSet rs = pstmt.executeQuery()) {
	               // 결과 처리
	               while (rs.next()) {
	                   clubMember cmember = new clubMember();
	                   cmember.setMemberId(rs.getString("memberId"));
	                   cmember.setClubNum(rs.getInt("clubNum"));
	                   cmember.setClubName(rs.getString("clubName"));
	                   cmember.setJoinDate(rs.getString("joinDate"));
	                   cmember.setMemberphone(rs.getString("memberphone"));
	                   cmember.setMemberemail(rs.getString("memberemail"));
	                   cmember.setMemberjoin(rs.getInt("memberJoin"));
	                   clubMembers.add(cmember); // 리스트에 추가
	               }
	           }
	       } catch (Exception e) {
	           e.printStackTrace();
	       }
	       return clubMembers; // 클럽 멤버 리스트 반환
	}
	// Club 멤버 가입 승인
	@Override
	public void approveMember(String memberId, int clubNum) {
	    String sql = "UPDATE clubMember SET memberJoin = 1 WHERE memberId = ? AND clubNum = ?";
	    
	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        
	        // 멤버 ID 및 클럽 번호 설정
	        pstmt.setString(1, memberId);
	        pstmt.setInt(2, clubNum);
	        
	        // 쿼리 실행
	        pstmt.executeUpdate();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	@Override
	public void cancelMember(String memberId, int clubNum) {
	    String sql = "DELETE FROM clubMember WHERE memberId = ? AND clubNum = ?";
	    
	    try {
	        conn = DBConnection.getConnection(); // 데이터베이스 연결
	        pstmt = conn.prepareStatement(sql); // SQL 쿼리 준비
	        pstmt.setString(1, memberId); // memberId 설정
	        pstmt.setInt(2, clubNum); // clubNum 설정
	        
	        pstmt.executeUpdate(); // 쿼리 실행
	        
	    } catch (Exception e) {
	        e.printStackTrace(); // 예외 발생 시 스택 트레이스를 출력
	    } finally {
	        try {
	            if (pstmt != null) pstmt.close(); // PreparedStatement 해제
	            if (conn != null) conn.close(); // Connection 해제
	        } catch (Exception e) {
	            e.printStackTrace(); // 해제 중 예외 발생 시 출력
	        }
	    }
	}
	@Override
	public void minusmemberCount(int clubNum) {
		String sql = "UPDATE club SET memberCount = memberCount - 1 WHERE clubNum = ?";
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, clubNum);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
	        try {
	            if (pstmt != null) pstmt.close(); // PreparedStatement 해제
	            if (conn != null) conn.close(); // Connection 해제
	        } catch (Exception e) {
	            e.printStackTrace(); // 해제 중 예외 발생 시 출력
	        }
	    }
		
	}
	
	// club 게시글 작성
	@Override
	public void writeboard(clubboard clubboard) {
		System.out.println("clubRepositoryImpl writeboard()");
		try {
			conn=DBConnection.getConnection();
			String sql = "insert into clubboard(memberid, subject, content, regist_date, hit, clubNum) values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, clubboard.getMemberid());
			pstmt.setString(2, clubboard.getSubject());
			pstmt.setString(3, clubboard.getContent());
			pstmt.setString(4, clubboard.getRegist_date());
			pstmt.setInt(5, clubboard.getHit());
			pstmt.setInt(6, clubboard.getClubNum());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	// 커뮤니티 페이지 네이션
	@Override
	public int getTotalClubBoardCount(int clubNum) {
		int count = 0;
	    try {
	        conn = DBConnection.getConnection();
	        String sql = "SELECT COUNT(*) FROM clubboard WHERE clubNum=?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, clubNum);
	        rs = pstmt.executeQuery();
	        
	        if (rs.next()) {
	            count = rs.getInt(1);
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return count;
	}
	// 클럽 커뮤니티 getallboard R
	@Override
	public List<clubboard> getAllclubboard(int clubNum, int page, int pageSize) {
	    List<clubboard> clubboards = new ArrayList<>();
	    String sql = "SELECT * FROM clubboard WHERE clubNum = ? ORDER BY num DESC LIMIT ? OFFSET ?"; // LIMIT과 OFFSET 추가

	    try {
	        conn = DBConnection.getConnection();
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, clubNum);
	        pstmt.setInt(2, pageSize); // 페이지당 게시글 수
	        pstmt.setInt(3, (page - 1) * pageSize); // OFFSET 계산

	        ResultSet rs = pstmt.executeQuery();
	        
	        while (rs.next()) {
	            clubboard board = new clubboard();
	            board.setBoardnum(rs.getInt("num")); // 게시글 번호
	            board.setMemberid(rs.getString("memberid")); // 작성자 ID
	            board.setSubject(rs.getString("subject")); // 제목
	            board.setContent(rs.getString("content")); // 내용
	            board.setRegist_date(rs.getString("regist_date")); // 등록일
	            board.setHit(rs.getInt("hit")); // 조회 수
	            board.setClubNum(rs.getInt("clubNum")); // 클럽 번호
	            
	            clubboards.add(board);
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (pstmt != null) pstmt.close(); // PreparedStatement 해제
	            if (conn != null) conn.close(); // Connection 해제
	        } catch (Exception e) {
	            e.printStackTrace(); // 해제 중 예외 발생 시 출력
	        }
	    }
	    
	    return clubboards; // 클럽 게시글 리스트 반환
	}
	// 페이지네이션 search 토탈 카운트
	@Override
	public int getTotalSearchBoardCount(int clubNum, String items, String text) {
	    int totalCount = 0; // 총 게시글 수를 저장할 변수
	    String sql = "SELECT COUNT(*) FROM clubboard WHERE " + items + " LIKE ? AND clubNum = ?";

	    try {
	        conn = DBConnection.getConnection();
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, "%" + text + "%"); // 검색어 조건
	        pstmt.setInt(2, clubNum); // 클럽 번호 조건
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            totalCount = rs.getInt(1); // 첫 번째 컬럼의 값이 총 게시글 수
	            System.out.println(totalCount);
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); // 예외 처리
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (Exception e) {
	            e.printStackTrace(); // 해제 중 예외 발생 시 출력
	        }
	    }
	    return totalCount; // 총 게시글 수 반환
	}
	// 게시글 Search 결과 R
	@Override
	public List<clubboard> searchClubBoard(int clubNum, String items, String text, int page, int pageSize) {
	    List<clubboard> clubboards = new ArrayList<>();
	    
	    try {
	        conn = DBConnection.getConnection();
	        // SQL 쿼리 작성: clubNum에 맞는 게시글을 검색
	        String sql = "SELECT * FROM clubboard WHERE " + items + " LIKE ? AND clubNum = ? ORDER BY num DESC LIMIT ? OFFSET ?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, "%" + text + "%"); // 검색어 조건
	        pstmt.setInt(2, clubNum); // 클럽 번호 조건
	        pstmt.setInt(3, pageSize); // 페이지당 게시글 수
	        pstmt.setInt(4, (page - 1) * pageSize); // OFFSET 계산
	        
	        rs = pstmt.executeQuery();
	        
	        while (rs.next()) {
	            clubboard board = new clubboard();
	            board.setBoardnum(rs.getInt("num")); // 게시글 번호
	            board.setMemberid(rs.getString("memberid")); // 작성자 ID
	            board.setSubject(rs.getString("subject")); // 제목
	            board.setContent(rs.getString("content")); // 내용
	            board.setRegist_date(rs.getString("regist_date")); // 등록일
	            board.setHit(rs.getInt("hit")); // 조회 수
	            board.setClubNum(rs.getInt("clubNum")); // 클럽 번호
	            
	            clubboards.add(board); // 리스트에 추가
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); // 예외 처리
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (Exception e) {
	            e.printStackTrace(); // 해제 중 예외 발생 시 출력
	        }
	    }
	    
	    return clubboards; // 검색된 게시글 리스트 반환
	}
	// club 커뮤니티 getoneclubboard R
	@Override
	public clubboard getOneclubboard(int boardnum) {
		clubboard clubboard = new clubboard();
		String sql = "select * from clubboard where num = ?";
		try {
			conn = DBConnection.getConnection();
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, boardnum);
	        rs = pstmt.executeQuery();
	        
	        if(rs.next()) {
	        	clubboard.setBoardnum(rs.getInt("num")); // 게시글 번호
	        	clubboard.setMemberid(rs.getString("memberid")); // 작성자 ID
	        	clubboard.setSubject(rs.getString("subject")); // 제목
	        	clubboard.setContent(rs.getString("content")); // 내용
	        	clubboard.setRegist_date(rs.getString("regist_date")); // 등록일
	        	clubboard.setHit(rs.getInt("hit")); // 조회 수
	        	clubboard.setClubNum(rs.getInt("clubNum")); // 클럽 번호
	        }
	        
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return clubboard;
	}
	// 게시판 조회 수 증가
	@Override
	public void incrementhit(int num) {
		try {
			conn=DBConnection.getConnection();
			String sql = "update clubboard set hit = hit+1 where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// club board Update
	@Override
	public void updateClubboard(clubboard clubboard) {
		System.out.println("clubRepositoryImpl updateclubboard()");
		
		try {
			conn=DBConnection.getConnection();
			String sql = "update clubboard set subject=?, content=? where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, clubboard.getSubject());       // subject
			pstmt.setString(2, clubboard.getContent());       // content
			pstmt.setInt(3, clubboard.getBoardnum()); 
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	//club board delete
	@Override
	public void deleteclubboard(int boardnum) {
		System.out.println("clubRepositoryImpl deleteclubboard()");
		try {
			conn=DBConnection.getConnection();
			String sql = "delete from clubboard where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardnum); 
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	// club board comment C
	@Override
	public void saveComment(clubboardcomment cbcommentDto) {
		
			System.out.println("CommentRepositoryImpl addComment()");
		    System.out.println("댓글 내용: " + cbcommentDto.getCommentcontent());
		    try {
				conn=DBConnection.getConnection();
				String sql = "INSERT INTO clubcomments (boardnum,clubNum, commentcontent, authorid, createDate, likes) VALUES (?, ?, ?, ?, ?, ?)";
		        pstmt = conn.prepareStatement(sql);
		        pstmt.setInt(1, cbcommentDto.getBoardnum());
		        pstmt.setInt(2, cbcommentDto.getClubNum());
		        pstmt.setString(3, cbcommentDto.getCommentcontent());
		        pstmt.setString(4, cbcommentDto.getAuthorid());
		        pstmt.setString(5, cbcommentDto.getCreatedDate()); // String을 직접 설정
		        pstmt.setInt(6, cbcommentDto.getLikes());
				
				pstmt.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		   
		
	}
	// 게시글 번호로 댓글 불러오기
    @Override
    public List<clubboardcomment> getCommentsByBoardNum(int boardnum) {
        List<clubboardcomment> comments = new ArrayList<>();
        try {
            conn = DBConnection.getConnection(); // DB 연결
            String sql = "SELECT * FROM clubcomments WHERE boardnum = ?"; // 게시글 번호로 댓글 조회
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, boardnum);
            rs = pstmt.executeQuery(); // 쿼리 실행
            
            while (rs.next()) {
                clubboardcomment comment = new clubboardcomment();
                comment.setCommentnum(rs.getInt("commentnum")); // 댓글 번호
                comment.setBoardnum(rs.getInt("boardnum")); // 게시글 번호
                comment.setClubNum(rs.getInt("clubNum")); // 클럽 번호
                comment.setCommentcontent(rs.getString("commentcontent")); // 댓글 내용
                comment.setAuthorid(rs.getString("authorid")); // 작성자 ID
                comment.setCreatedDate(rs.getString("createDate")); // 생성일
                comment.setLikes(rs.getInt("likes")); // 좋아요 수
                comments.add(comment); // 댓글 리스트에 추가
            }
        } catch (Exception e) {
            e.printStackTrace(); // 오류 로그 출력
        } finally {
            // 리소스 정리
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return comments; // 댓글 리스트 반환
    }
    // 댓글 수정하기
	@Override
	public boolean updateComment(clubboardcomment commentDto) {
		boolean isUpdated = false;
        try {
            conn = DBConnection.getConnection(); // DB 연결
            String sql = "UPDATE clubcomments SET commentcontent = ? WHERE commentnum = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, commentDto.getCommentcontent()); // 수정할 댓글 내용
            pstmt.setInt(2, commentDto.getCommentnum()); // 댓글 번호
            
            int rowsAffected = pstmt.executeUpdate(); // 쿼리 실행
            isUpdated = rowsAffected > 0; // 수정 성공 여부 확인
        } catch (Exception e) {
            e.printStackTrace(); // 오류 로그 출력
        } finally {
            // 리소스 정리
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isUpdated; // 수정 성공 여부 반환
	}
	// 댓글 삭제 기능
	@Override
	public boolean deleteComment(int commentnum) {
		 boolean isDeleted = false;
	        try {
	            conn = DBConnection.getConnection(); // DB 연결
	            String sql = "DELETE FROM clubcomments WHERE commentnum = ?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, commentnum); // 댓글 번호 설정
	            
	            int rowsAffected = pstmt.executeUpdate(); // 쿼리 실행
	            isDeleted = rowsAffected > 0; // 삭제 성공 여부 확인
	        } catch (Exception e) {
	            e.printStackTrace(); // 오류 로그 출력
	        } finally {
	            // 리소스 정리
	            try {
	                if (pstmt != null) pstmt.close();
	                if (conn != null) conn.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return isDeleted; // 삭제 성공 여부 반환
	}

	
	
	
}
