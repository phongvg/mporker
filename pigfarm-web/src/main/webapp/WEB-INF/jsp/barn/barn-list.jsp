<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/themes/common/taglibs.jsp"%>

<head>
  <title><fmt:message key="barn.list.title"/></title>
  <meta name="menu" content="barnMenu"/>
  <script src="<c:url value='/themes/admin/global_assets/js/plugins/forms/validation/validate.min.js'/>"></script>
  <link href="<c:url value='/themes/admin/assets/css/custom_style.css'/>" rel="stylesheet" type="text/css">
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
      <security:authorize access="hasAnyRole('ROLE_ADMIN,ROLE_BARN_CREATE')">
        <a id="addFarm" href="<c:url value='/barn/form?farmCode=${farmCode}'/>" class="btn btn-sm bgc-warning text-white"><i class="icon-plus22"></i> <fmt:message key="button.add" /></a>
      </security:authorize>
    </div>
  </div>
  <form:form id="barnForm" modelAttribute="criteria" action="/barn/list"  method="post">
    <!-- \Table -->
    <div class="card">
      <div class="table-responsive">
        <table class="table table-bordered table-striped">
          <thead>
          <tr class="table-success">
            <th class="text-center bgc-primary border-primary text-white" style="width: 10px">#</th>
            <th class="text-center bgc-primary border-primary text-white"><fmt:message key="barn.name" /></th>
            <th class="text-center bgc-primary border-primary text-white"><fmt:message key="barn.name" /></th>
            <th class="text-center bgc-primary border-primary text-white"><fmt:message key="barn.farmCode" /></th>
            <th class="text-center bgc-primary border-primary text-white"><fmt:message key="barn.pig.total" /></th>
            <th class="text-center bgc-primary border-primary text-white"><fmt:message key="barn.pig.total.dead" /></th>
            <th class="text-center bgc-primary border-primary text-white" style="width: 120px;"><i class="icon-menu-open2"></i></th>
          </tr>
          </thead>
          <tbody>
          <c:if test="${empty page.content}">
            <tr>
              <td colspan="5" class="text-center text-none-data"><fmt:message key="not.data" /></td>
            </tr>
          </c:if>
          <c:forEach var="barn" items="${page.content}" varStatus="cnt">
            <tr>
              <td class="text-center"><c:out value="${cnt.count+page.size*page.number}" /></td>
              <td class="text-center">${barn.code}</td>
              <td class="text-center">${barn.name}</td>
              <td class="text-center">${barn.farm.code}</td>
              <td class="text-center">${barn.totalPigRetained}</td>
              <td class="text-center">${barn.totalPigDead}</td>
              <security:authorize access="hasAnyRole('ROLE_ADMIN,ROLE_BARN_UPDATE')">
                <td class="text-center">
                  <div class="list-icons">
                    <div class="dropdown">
                      <a href="#" class="list-icons-item dropdown-toggle" data-toggle="dropdown"><i class="icon-menu7 fontSize20"></i></a>
                      <div class="dropdown-menu">
                        <div class="dropdown-header">Options</div>
                        <a href="<c:url value="/barn/form?id=${barn.id}&farmCode=${farmCode}"/>" class="dropdown-item"><i class="icon-pencil7"></i><fmt:message key="button.edit"/></a>
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


