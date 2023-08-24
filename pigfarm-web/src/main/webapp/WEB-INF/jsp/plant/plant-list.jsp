<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/themes/common/taglibs.jsp"%>

<head>
  <title><fmt:message key="plant.list.title" /></title>
  <meta name="menu" content="plantMenu" />
</head>

<div class="row mb-3">
  <div class="col-12"><%@include file="/themes/admin/common/actions.jsp"%></div>
</div>

<div class="content">
  <div class="row mb-3">
    <div class="col-12 col-md-6">
      <div class="text-color-primary fs-5"><fmt:message key="plant.list.title" /></div>
    </div>
    <div class="col-12 col-md-6 text-right">
      <security:authorize access="hasAnyRole('ROLE_ADMIN,ROLE_PLANT_CREATE')">
        <a id="addFarm" href="<c:url value='/plant/form'/>" class="btn btn-sm bgc-warning text-white"><i class="icon-plus22"></i> <fmt:message key="button.add" /></a>
      </security:authorize>
    </div>
  </div>
  <form:form id="plantForm" modelAttribute="criteria" action="/plant/list" method="post">
    <!-- \Searching -->
    <div class="card rounded-16">
      <div class="row"><div class="col-12 px-3 py-2 fw-bold"><fmt:message key="label.search" /></div></div>
      <div class="card-body py-0">
        <div class="row">
          <div class="col-md-4">
            <div class="form-group">
              <label><fmt:message key="plant.code" /></label>
              <input class="form-control rounded-10" type="text" name="code" value="${criteria.code}" placeholder="<fmt:message key="plant.code" />" />
            </div>
          </div>
          <div class="col-md-4">
            <div class="form-group">
              <label><fmt:message key="plant.name" /></label>
              <input class="form-control rounded-10" name="name" value="${criteria.name}" placeholder="<fmt:message key="plant.name" />"/>
            </div>
          </div>
          <div class="col-4 text-right mt-3">
            <button type="submit" class="btn btn-secondary rounded-20" onclick="searchFunction()"><i class="icon-search4 mr-2"></i><fmt:message key="button.search" /></button>
          </div>
        </div>
      </div>
    </div>
    <!-- /Searching -->

    <!-- \Table -->
    <div class="card">
      <div class="table-responsive">
        <table class="table table-bordered table-striped">
          <thead>
          <tr class="table-success">
            <th class="text-center bgc-primary border-primary text-white" style="width: 10px">#</th>
            <th class="text-center bgc-primary border-primary text-white"><fmt:message key="company.name" /></th>
            <th class="text-center bgc-primary border-primary text-white"><fmt:message key="plant.code" /></th>
            <th class="text-center bgc-primary border-primary text-white"><fmt:message key="plant.name" /></th>
            <th class="text-center bgc-primary border-primary text-white" style="width: 120px;"><i class="icon-menu-open2"></i></th>
          </tr>
          </thead>
          <tbody>
          <c:if test="${empty page.content}">
            <tr>
              <td colspan="5" class="text-center text-none-data"><fmt:message key="not.data" /></td>
            </tr>
          </c:if>
          <c:forEach var="plant" items="${page.content}" varStatus="cnt">
            <tr>
              <td class="text-center"><c:out value="${cnt.count+page.size*page.number}" /></td>
              <td class="text-center">${plant.company.name}</td>
              <td class="text-center">${plant.code}</td>
              <td class="text-center">${plant.name}</td>
              <security:authorize access="hasAnyRole('ROLE_ADMIN,ROLE_PLANT_UPDATE')">
                <td class="text-center">
                  <div class="list-icons">
                    <div class="dropdown">
                      <a href="#" class="list-icons-item dropdown-toggle" data-toggle="dropdown"><i class="icon-menu7 fontSize20"></i></a>
                      <div class="dropdown-menu">
                        <div class="dropdown-header">Options</div>
                        <a href="<c:url value="/plant/form?id=${plant.id}"/>" class="dropdown-item"><i class="icon-pencil7"></i><fmt:message key="button.edit"/></a>
                      </div>
                    </div>
                  </div>
                </td>
              </security:authorize>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>
      <!-- 		Pagination -->
      <jsp:include page="/themes/admin/common/pagination.jsp">
        <jsp:param value="${page.number}" name="pageNumber" />
        <jsp:param value="${page.totalPages}" name="maxPages" />
        <jsp:param value="${page.size}" name="size" />
        <jsp:param value="${page.totalElements}" name="totalElements" />
      </jsp:include>
    </div>
    <!-- /Table -->
  </form:form>
</div>
<script>
  function searchFunction(){
    $('#page').val(0);
  }
</script>