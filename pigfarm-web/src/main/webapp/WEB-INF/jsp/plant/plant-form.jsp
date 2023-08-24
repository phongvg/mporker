<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/themes/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="company.form.title" /></title>
    <meta name="menu" content="plantMenu" />
    <script src="<c:url value='/themes/admin/global_assets/js/plugins/forms/selects/select2.min.js'/>"></script>
    <script src="<c:url value='/themes/admin/global_assets/js/plugins/forms/validation/validate.min.js'/>"></script>
    <script	src="<c:url value='/themes/admin/assets/js/plant/plant_form.js'/>"></script>
</head>

<div class="row mb-3">
    <div class="col-12"><%@include file="/themes/admin/common/actions.jsp"%></div>
</div>
<!-- Content area -->
<div class="content">
    <form:form id="plantForm" modelAttribute="plantDto" action="${ctx}/plant/save" method="post" role="form">
        <form:hidden path="id" id="id" />
        <!-- Basic layout-->
        <div class="card">
            <div class="card-header header-elements-inline">
                <span class="text-uppercase font-size-lg font-weight-bold"><fmt:message key="company.form.title" /></span>
            </div>
            <div class="card-body">
                <fieldset class="mb-3">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label><fmt:message key="plant.code" /><span class="help-block">*</span></label>
                                <c:choose>
                                    <c:when test="${not empty plantDto.id}">
                                        <form:input path="code" id="code" class="form-control" readonly="true"/>
                                    </c:when>
                                    <c:otherwise>
                                        <form:input path="code" id="code" class="form-control" required="required"/>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label><fmt:message key="plant.name" /><span class="help-block">*</span></label>
                                <form:input path="name" id="name" class="form-control" required="required"/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label><fmt:message key="company.code" /><span class="help-block">*</span></label>
                                <select	id="companyCode" name="company.code" class="form-control select2" data-placeholder="Chọn mã công ty">
                                    <option value=""></option>
                                    <c:forEach var="item" items="${companies}">
                                        <option value="${item.code}" ${item.code == plantDto.company.code ? 'selected="selected"' : ''}><c:out value="${item.code} - ${item.name}"></c:out></option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label><fmt:message key="farm.status" /><span class="help-block">*</span></label>
                                <form:select id="status" path="status" class="form-control select2" data-placeholder="Chọn trạng thái" required="required">
                                    <option value="active" ${companyDto.status == 'active' ? 'selected="selected"' : ''}><fmt:message key="farm.status.active" /></option>
                                    <option value="inactive" ${companyDto.status == 'inactive' ? 'selected="selected"' : ''}><fmt:message key="farm.status.inactive" /></option>
                                </form:select>
                            </div>
                        </div>
                    </div>
                    <div class="d-flex justify-content-end align-items-center">
                        <a href="<c:url value="/plant/list"/>" id="back" class="btn btn-light"><i class="icon-point-left mr-2"></i> <fmt:message key="button.back" /></a>
                        <security:authorize access="hasAnyRole('ROLE_ADMIN,ROLE_PLANT_UPDATE')">
                            <button type="submit" class="btn btn-primary ml-3"><fmt:message key="button.save" /><i class="icon-database-insert ml-2"></i></button>
                        </security:authorize>
                    </div>
                </fieldset>
            </div>
        </div>
        <!-- /basic layout -->
    </form:form>
</div>
<!-- /content area -->
