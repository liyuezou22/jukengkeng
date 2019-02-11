app.service("sellerService",function ($http) {
    
    this.queryList = function (pageNum,pageSize,searchEntity) {
        return $http.post("../seller/queryListSeller.do?pageNum="+pageNum+"&pageSize="+pageSize,searchEntity);
    }
});