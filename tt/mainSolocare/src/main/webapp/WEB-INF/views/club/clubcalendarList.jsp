<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>일정 관리</title>
    <!-- FullCalendar CSS -->
    <link href='https://cdn.jsdelivr.net/npm/fullcalendar@5.10.2/main.min.css' rel='stylesheet' />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    
    <style>
        :root {
            --primary-color: #3498db;
            --background-color: #f4f6f7;
            --text-color: #2c3e50;
        }

        body {
            font-family: 'Noto Sans KR', Arial, sans-serif;
            background-color: var(--background-color);
            color: var(--text-color);
            margin: 0;
            padding: 20px;
            line-height: 1.6;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0,0,0,0.1);
            padding: 20px;
        }

        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
        }

        #calendar {
            max-width: 100%;
        }

        .add-event-btn {
            background-color: var(--primary-color);
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            display: flex;
            align-items: center;
            gap: 10px;
        }

        .add-event-btn:hover {
            background-color: #2980b9;
        }

        .home-btn {
            background-color: transparent;
            border: none;
            cursor: pointer;
            display: flex;
            align-items: center;
            font-size: 24px;
            color: var(--primary-color);
        }

        .home-btn:hover {
            color: #2980b9;
        }

        /* 모달 스타일 */
        .modal {
            position: fixed;
            z-index: 1000;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0,0,0,0.5);
            display: none;
            align-items: center;
            justify-content: center;
        }

        .modal-content {
            background-color: white;
            border-radius: 10px;
            width: 90%;
            max-width: 500px;
            padding: 25px;
            box-shadow: 0 5px 15px rgba(0,0,0,0.3);
            position: relative;
        }

        .close-btn {
            position: absolute;
            top: 10px;
            right: 15px;
            color: #aaa;
            font-size: 28px;
            font-weight: bold;
            cursor: pointer;
            transition: color 0.3s;
        }

        .close-btn:hover {
            color: var(--primary-color);
        }

        #eventDetails h3 {
            color: var(--primary-color);
            border-bottom: 2px solid var(--primary-color);
            padding-bottom: 10px;
        }

        .modal-buttons {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
        }

        .modal-buttons button {
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        #edit-btn {
            background-color: var(--primary-color);
            color: white;
        }

        #delete-btn {
            background-color: #e74c3c;
            color: white;
        }

        #edit-btn:hover {
            background-color: #2980b9;
        }

        #delete-btn:hover {
            background-color: #c0392b;
        }

        /* FullCalendar 커스터마이징 */
        .fc-toolbar-title {
            color: var(--primary-color);
            font-weight: bold;
        }

        .fc-button {
            background-color: var(--primary-color) !important;
            border: none !important;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <button class="home-btn" onclick="location.href='/Solocare/home'">
                <i class="fas fa-home"></i> 홈
            </button>
            <button class="add-event-btn" onclick="location.href='${pageContext.request.contextPath}/club/clubcalendar/add/${clubNum}'">
   				<i class="fas fa-plus"></i> 일정 추가
   			</button>
        </div>
        <div id='calendar'></div>
    </div>

    <!-- 모달 다이얼로그 -->
    <div id="eventModal" class="modal">
        <div class="modal-content">
            <span class="close-btn" id="closeModal">&times;</span>
            <div id="eventDetails"></div>
            <div class="modal-buttons">
                <button id="edit-btn">수정</button>
                <button id="delete-btn">삭제</button>
            </div>
        </div>
    </div>

    <!-- FullCalendar JS and Dependencies -->
    <script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.10.2/main.min.js'></script>
    <script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.10.2/locales/ko.js'></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/js/all.min.js"></script>

   <script>
    document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
            initialView: 'dayGridMonth',
            locale: 'ko',
            headerToolbar: {
                left: 'prev,next today',
                center: 'title',
                right: 'dayGridMonth,timeGridWeek,timeGridDay'
            },
            events: [
                <c:forEach var="event" items="${events}" varStatus="status">
                {
                    title: '<c:out value="${event.title}" escapeXml="true"/>',
                    start: '${event.start}', 
                    end: '${event.end}', 
                    id: '${event.calendarNum}', 
                    extendedProps: {
                        description: '<c:out value="${event.description}" escapeXml="true"/>',
                        clubName: '<c:out value="${event.clubname}" escapeXml="true"/>' 
                    }
                }${!status.last ? ',' : ''}
                </c:forEach>
            ],
            eventClick: function(info) {
                var eventId = info.event.id; // 캘린더 번호(클럽번호)
                var eventTitle = info.event.title.replace(/'/g, "\\'");
                var eventDescription = info.event.extendedProps.description ? info.event.extendedProps.description.replace(/'/g, "\\'") : '';
                var eventStart = info.event.start ? info.event.start.toLocaleString('ko-KR') : ''; 
                var eventEnd = info.event.end ? info.event.end.toLocaleString('ko-KR') : ''; 
                var clubName = info.event.extendedProps.clubName; // 클럽 이름

                var detailsHtml = 
                    '<h3>일정 상세 정보</h3>' +
                    '<p><strong>동호회:</strong> ' + clubName + '</p>' + // 클럽 이름 표시
                    '<p><strong>제목:</strong> ' + eventTitle + '</p>' + // 제목 표시
                    '<p><strong>내용:</strong> ' + eventDescription + '</p>' +
                    '<p><strong>시작:</strong> ' + eventStart + '</p>' +
                    '<p><strong>종료:</strong> ' + eventEnd + '</p>';
                
                document.getElementById('eventDetails').innerHTML = detailsHtml;

                document.getElementById('edit-btn').onclick = function() {
                    window.location.href = eventId+'/edit/' + eventTitle; // 수정 페이지로 이동
                };

                document.getElementById('delete-btn').onclick = function() {
                    if (confirm('정말 삭제하시겠습니까?')) {
                        window.location.href = eventId+'/delete/' + eventTitle; // 삭제 요청
                    }
                };

                document.getElementById('eventModal').style.display = 'flex';
            }
        });
        calendar.render();

        document.getElementById('closeModal').onclick = function() {
            document.getElementById('eventModal').style.display = 'none';
        };

        window.onclick = function(event) {
            if (event.target == document.getElementById('eventModal')) {
                document.getElementById('eventModal').style.display = 'none';
            }
        };
    });
</script>

    <c:if test="${not empty errorMessage}">
        <script>
            alert('${errorMessage}');
        </script>
    </c:if>
</body>
</html>
