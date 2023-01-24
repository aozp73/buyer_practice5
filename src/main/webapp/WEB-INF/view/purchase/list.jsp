<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ include file="../layout/header.jsp" %>

        <h1>구매 목록</h1>
        <table border="1">
            <tr>
                <th>번호</th>
                <th>구매자</th>
                <th>구매품</th>
                <th>구매갯수</th>
            </tr>
            <c:forEach items="${pruchase}" var="pruchase">
                <tr>
                    <td>${pruchase.id}</td>
                    <td>${pruchase.username}</td>
                    <td>${pruchase.name}</td>
                    <td>${pruchase.count}</td>
                </tr>
            </c:forEach>
        </table>

        <%@ include file="../layout/footer.jsp" %>