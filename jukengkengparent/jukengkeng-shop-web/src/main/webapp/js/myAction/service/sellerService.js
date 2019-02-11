app.service("sellerService",function ($http) {
    //新增商家：商家入驻
    this.addSeller = function (entity) {
        return $http.post("../seller/add.do",entity);
    }
});