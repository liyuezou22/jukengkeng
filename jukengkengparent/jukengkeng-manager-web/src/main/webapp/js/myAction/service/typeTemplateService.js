app.service("typeTemplateService", function ($http) {
    this.queryList = function (pageNum, pageSize, searchEntity) {
        return $http.post("../typeTemplate/findPageList.do?pageNum=" + pageNum + "&pageSize=" + pageSize, searchEntity);
    }

    //保存商品类型模板
    this.saveTypeTemplate = function (entity) {
        return $http.post("../typeTemplate/saveTypeTemplate.do", entity);
    }

    //删除商品类型模板
    this.delTypeTemplate = function (selectIds) {
        return $http.post("../typeTemplate/delTypeTemplate.do?ids=" + selectIds);
    }

    //根据ID查询商品类型模板
    this.queryTypeTemplate = function (id) {
        return $http.post("../typeTemplate/queryTypeTemplateByID.do?id=" + id);
    }
    //根据名称查询商品类型模板
    this.queryTypeTemplateByName = function (searchEntity, pageNum, pageSize) {
        return $http.post("../typeTemplate/queryTypeTemplateByName.do?pageNum=" + pageNum + "&pageSize=" + pageSize, searchEntity);
    }
    //更新商品类型模板
    this.updateTypeTemplate = function (entity) {
        return $http.post("../typeTemplate/updateTypeTemplate.do", entity);
    }
});