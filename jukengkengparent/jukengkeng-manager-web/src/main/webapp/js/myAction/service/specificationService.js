app.service("specificationService", function ($http) {
    //分页查询service
    this.queryList = function (pageNum, pageSize, searchEntity) {
        return $http.post("../specification/findPageList.do?pageNum=" + pageNum + "&pageSize=" + pageSize, searchEntity);
    }

    //新增规格及规格选项
    this.addSpecification = function (specification) {
        return $http.post("../specification/add.do",specification);
    }
    
    //删除规格及规格选项
    this.delSpecifciation = function (selectIds) {
        return $http.post("../specification/del.do?id="+selectIds);
    }
});