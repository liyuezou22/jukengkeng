//定义业务层
app.service("brandService", function ($http) {
    //查询所有
    this.findAll = function () {
        return $http.post("../brands/findAll.do");
    }
    //新增
    this.add = function (entity) {
        return $http.post("../brands/add.do", entity);
    }
    //修改
    this.updateTbBrand = function (entity) {
        return $http.post("../brands/updateTbBrand.do", entity);
    }
    //根据主键查询
    this.findByID = function (id) {
        return  $http.post("../brands/findTbBrand.do?rowid=" + id);
    }
    //删除
    this.del = function (selectIds) {
        return $http.post("../brands/del.do?ids=" + selectIds);
    }
    //调减查询
    this.queryList = function (pageNum, pageSize,searchEntity) {
        return  $http.post("../brands/findPageListByLike.do?pageNum=" + pageNum + "&pageSize=" + pageSize,searchEntity);
    }
});