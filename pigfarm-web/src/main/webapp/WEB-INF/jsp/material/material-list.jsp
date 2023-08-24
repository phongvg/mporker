<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/themes/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="material.list.title" /></title>
    <meta name="menu" content="materialMenu" />

    <script src="<c:url value='/themes/admin/assets/js/material_list.js'/>"></script>
    <script src="<c:url value='/themes/admin/global_assets/js/plugins/uploaders/fileinput/plugins/purify.min.js'/>"></script>
    <script src="<c:url value='/themes/admin/global_assets/js/plugins/uploaders/fileinput/plugins/sortable.min.js'/>"></script>
    <script src="<c:url value='/themes/admin/global_assets/js/plugins/uploaders/fileinput/fileinput.min.js'/>"></script><script src="<c:url value='/themes/admin/global_assets/js/plugins/forms/validation/validate.min.js'/>"></script>
    <link href="<c:url value='/themes/admin/assets/css/custom_style.css'/>" rel="stylesheet" type="text/css">
    <script src="<c:url value='/themes/admin/global_assets/js/plugins/uploaders/fileinput/fileinput.min.js'/>"></script>
</head>

<div class="row mb-3">
    <div class="col-12"><%@include file="/themes/admin/common/actions.jsp"%></div>
</div>

<div class="content">
    <div class="row mb-3">
        <div class="col-12 col-md-6">
            <div class="text-color-primary fs-5"><fmt:message key="material.list.title" /></div>
        </div>
        <div class="col-12 col-md-6 text-right">
            <a href="#" class="btn btn-sm bgc-warning text-white" data-toggle="modal" data-target="#modal_import" data-backdrop="static" data-keyboard="false"><i class="icon-cloud-download2"></i> <fmt:message key="button.import.material" /></a>
            <a href="#" id="exportFile" class="btn btn-sm bgc-warning text-white"><i class="icon-file-upload"></i> <fmt:message key="button.export.material" /></a>
            <security:authorize access="hasAnyRole('ROLE_ADMIN,ROLE_FARM_CREATE')">
                <a id="addFarm" href="<c:url value='/material/form'/>" class="btn btn-sm bgc-warning text-white"><i class="icon-plus22"></i> <fmt:message key="button.add" /></a>
            </security:authorize>
        </div>
    </div>
    <form:form id="materialList" modelAttribute="criteria" action="${ctx}/material/list" method="post" enctype="multipart/form-data">
        <!-- \Searching -->
        <div class="card rounded-16">
            <div class="row"><div class="col-12 px-3 py-2 fw-bold"><fmt:message key="label.search" /></div></div>
            <div class="card-body py-0">
                <div class="row">
                    <div class="col-md-3">
                        <div class="form-group">
                            <label><fmt:message key="material.code.sap" /></label>
                            <input class="form-control rounded-10" type="text" id="code" name="code" value="${criteria.code}" placeholder="Nhập mã vật tư (Mã SAP)..." />
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="form-group">
                            <label><fmt:message key="material.name.sap" /></label>
                            <input class="form-control rounded-10" type="text" id="name" name="name" value="${criteria.name}" placeholder="Nhập tên vật tư (Tên theo SAP)..." />
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="form-group">
                            <label><fmt:message key="material.type" /></label>
                            <input class="form-control rounded-10" type="text" id="groupName" name="groupName" value="${criteria.groupName}" placeholder="Nhập tên nhóm vật tư..." />
                        </div>
                    </div>
                    <div class="col-3 text-right mt-3">
                        <button type="submit" onclick="searchFunction()" class="btn btn-secondary"><i class="icon-search4"></i><fmt:message key="button.search" /></button>
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
                        <th class="text-center bgc-primary border-primary text-white">#</th>
                        <th class=" bgc-primary border-primary text-white"><fmt:message key="material.suggest.name" /></th>
                        <th class=" bgc-primary border-primary text-white text-center"><fmt:message key="material.unit" /></th>
                        <th class=" bgc-primary border-primary text-white"><fmt:message key="material.groupName" /></th>
                        <th class=" bgc-primary border-primary text-white text-center"><fmt:message key="material.purchasingGroup" /></th>
                        <th class=" bgc-primary border-primary text-white"><fmt:message key="material.code.sap" /></th>
                        <th class=" bgc-primary border-primary text-white"><fmt:message key="material.name.sap" /></th>
                        <th class=" bgc-primary border-primary text-white"><fmt:message key="material.specification" /></th>
                        <th class="text-center bgc-primary border-primary text-white"><i class="icon-menu-open2"></i></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${empty page.content}">
                        <tr><td colspan="8" class="text-center text-none-data"><fmt:message key="not.data"/></td></tr>
                    </c:if>
                    <tr>
                        <c:forEach var="material" items="${page.content}" varStatus="cnt">
                    <tr id="rec-material${cnt.index}">
                        <td class="text-center">
                            <c:out value="${cnt.count+page.size*page.number}" />
                        </td>
                        <td>${material.suggestName}</td>
                        <td class="text-center">${material.unit}</td>
                        <td>${material.groupName}</td>
                        <td class="text-center">${material.purchasingGroup}</td>
                        <td>${material.code}</td>
                        <td>${material.name}</td>
                        <td>${material.description}</td>
                        <security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_MATERIAL_EDIT')">
                        <td class="text-center">
                            <div class="list-icons">
                                <div class="dropdown">
                                    <a href="#" class="list-icons-item dropdown-toggle" data-toggle="dropdown"><i class="icon-menu7 fontSize20"></i></a>
                                    <div class="dropdown-menu">
                                        <div class="dropdown-header">Options</div>
                                        <a href="<c:url value="/material/form?id=${material.id}"/>" class="dropdown-item"><i class="icon-pencil7"></i><fmt:message key="button.edit"/></a>
                                    </div>
                                </div>
                            </div>
                        </td>
                        </security:authorize>
                    </tr>
                    </c:forEach>
                    </tr>
                    </tbody>
                </table>
            </div>
            <!-- Pagination -->
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
<!-- modal import -->
<form:form id="materialSupportFormImport" action="${ctx}/materialSupport/import" method="post" modelAttribute="materialSupport" enctype="multipart/form-data">
    <div id="modal_import" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <span class="font-weight-semibold modal-title">LỰA CHỌN FILE CẦN IMPORT</span>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group row">
                        <div class="col-lg-12">
                            <input type="file" name="inputImport" class="file-input" data-show-preview="false" accept=".xls,.xlsx" data-fouc>
                        </div>
                    </div>

                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-link" data-dismiss="modal">Close</button>
                    <button type="submit" id="btnImport" class="btn bg-primary"><i class="icon-download7 mr-2"></i>Import Excel</button>
                </div>
            </div>
        </div>
    </div>
</form:form>
