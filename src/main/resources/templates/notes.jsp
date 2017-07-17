<html>
<head>
    <title>My Notes page</title>

</head>
<body>
<a href="../../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1>Notes List</h1>


<table class="table table-striped">
    <tr>
        <th width="80">ID</th>
        <th width="120">Last Name</th>
        <th width="120">First Name</th>
        <th width="120">Middle Name</th>
        <th width="120">Mob.tel.</th>
        <th width="120">Dom.tel.</th>
        <th width="120">Address</th>
        <th width="120">E-mail</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>

    <%--<c:if test="${!empty listEmployees}">--%>
    <%--<a th:if="!${all}" th:href="@{/ticket(all=true)}">All</a>--%>
    <%--<a th:if="${all}" th:href="@{/ticket}">Not resolved</a>--%>
    <%--<td th:if="${note.id!= null}" th:href="@{}">ID</td>--%>


    <tbody>

    <tr th:each="note : ${listNotes}">

        <td th:text="${note.id}"></td>
        <td th:text="${note.lastName}"></td>
        <td th:text="${note.firstName}"></td>
        <td th:text="${note.middleName}"></td>
        <td th:text="${note.telMobile}"></td>
        <td th:text="${note.telDomastic}"></td>
        <td th:text="${note.address}"></td>
        <td th:text="${note.email}"></td>
        <td><a th:href="@{/edit/${note.id})}"> Edit</a></td>
        <td><a th:href="@{/remove/${note.id})}"> Delete</a></td>

        <%--<td>--%>
        <%--<a th:style="${ticket.resolveDate != null}?'text-decoration:line-through;':''"--%>
        <%--th:href="@{/ticket/{id}/view(id=${ticket.id})}" th:text="${ticket.issue}"></a>--%>
        <%--</td>--%>

    </tr>
    </tbody>
</table>


<h1>Add a Note</h1>



<%--<c:url var="hotelsUrl" value="/hotels"/>--%>
<%--<form:form modelAttribute="searchCriteria" action="${hotelsUrl}" method="get" cssClass="inline">--%>

    <%--<form action="#" th:object="${searchCriteria}" th:action="@{/hotels}" method="get" class="inline">--%>


    <%--<c:url var="addAction" value="/employees/add"/>--%>
<%--<form:form action="${addAction}" commandName="employee">--%>



    <form action="#" th:object="${searchCriteria}" th:action="@{/notes/add}" commandName="employee">

    <table>
        <c:if test="${!empty employee.firstName}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="firstName">
                    <spring:message text="FirstName"/>
                </form:label>
            </td>
            <td>
                <form:input path="firstName"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="lastName">
                    <spring:message text="LastName"/>
                </form:label>
            </td>
            <td>
                <form:input path="lastName"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="position">
                    <spring:message text="Position"/>
                </form:label>
            </td>
            <td>
                <form:input path="position"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="salary">
                    <spring:message text="Salary"/>
                </form:label>
            </td>
            <td>
                <form:input path="salary"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty employee.firstName}">
                    <input type="submit"
                           value="<spring:message text="Edit Employee"/>"/>
                </c:if>
                <c:if test="${empty employee.firstName}">
                    <input type="submit"
                           value="<spring:message text="Add Employee"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
