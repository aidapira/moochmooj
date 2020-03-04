<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<h1>All Clothes</h1>
<table>
    <thead>
        <tr>
            <th>Title</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${clothes}" var="clothes">
        <tr>
            <td><c:out value="${clothes.title}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<a href="/books/new">New Clothes</a>