app.service("sellerService", function ($http) {
    //查询列表
    this.queryList = function (pageNum, pageSize, searchEntity) {
        return $http.post("../seller/queryListSeller.do?pageNum=" + pageNum + "&pageSize=" + pageSize, searchEntity);
    }

    //根据ID查询商家信息
    this.querySellerByID = function (id) {
        return $http.post("../seller/querySellerByID.do?rowid=" + id);
    }

    //商家审核
    this.changeStatus = function (id,status) {
        return $http.post("../seller/changStatus.do?rowid="+id+"&status="+status);
    }
});