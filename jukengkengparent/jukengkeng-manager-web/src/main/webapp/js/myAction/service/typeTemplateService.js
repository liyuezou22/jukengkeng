app.service("typeTemplateService", function ($http) {
    this.queryList = function (pageNum, pageSize, searchEntity) {
        return $http.post("../typeTemplate/findPageList.do?pageNum=" + pageNum + "&pageSize=" + pageSize, searchEntity);
    }
});