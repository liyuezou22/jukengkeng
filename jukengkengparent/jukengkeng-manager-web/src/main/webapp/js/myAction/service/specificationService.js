app.service("specificationService", function ($http) {
    //分页查询service
    this.queryList = function (pageNum, pageSize, searchEntity) {
        return $http.post("../specification/findPageList.do?pageNum=" + pageNum + "&pageSize=" + pageSize, searchEntity);
    }
});