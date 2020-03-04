
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
 
<h1>New Clothes</h1>
<form:form action="/clothes" method="post" modelAttribute="clothes">
    <p>
        <form:label path="title">Title</form:label>
        <form:errors path="title"/>
        <form:input path="title"/>
    </p>   
    <input type="submit" value="Submit"/>
</form:form>    

