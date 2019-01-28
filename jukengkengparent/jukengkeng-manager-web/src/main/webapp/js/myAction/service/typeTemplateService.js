app.service("typeTemplateService", function ($http) {
    this.queryList = function (pageNum, pageSize, searchEntity) {
        return $http.post("../typeTemplate/findPageList.do?pageNum=" + pageNum + "&pageSize=" + pageSize, searchEntity);
    }

    //保存商品类型模板
    this.saveTypeTemplate = function (entity) {
        return $http.post("../typeTemplate/saveTypeTemplate.do",entity);
    }
});