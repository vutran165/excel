appExcel.factory('excelService', ['$resource', '$http', '$window', '$q',
    function ($resource, $http, $window, $q) {

        var hostname = $window.location.hostname;
        var port = $window.location.port;
        var rootUrl = 'http://' + hostname + ':' + port;

        var result = {
            Url: rootUrl,
            single: function (data, callback) {
                $http.post(rootUrl + '/api/singleFile', data).then(callback);
            },
            multiple: function (data, callback) {
                $http.post(rootUrl + '/multipeFile', data).then(callback);
            }
        }

        return result;
    }]);

appExcel.controller('uploadFileController', ['$scope', '$rootScope', '$log', '$http', 'excelService',
    function ($scope, $rootScope, $log, $http, excelService) {

        var formData = new FormData();

        $scope.getTheFiles = function ($files) {
            console.log($files);
            angular.forEach($files, function (value, key) {
                formData.append("files", value);
            });
            
            // check value in FormData
            // for (var value of formData.values()) {
            //     console.log(value); 
            //  }
            
        }

        $scope.upload = function () {
            console.log(formData);
            excelService.single(formData, function (err) {
                conosle.log(err);
            });

        }

    }]);



appExcel.controller('singleFileController', ['$scope', '$rootScope', '$log', '$http', 'excelService',
    function ($scope, $rootScope, $log, $http, excelService) {

    }]);

appExcel.controller('multipleFileController', ['$scope', '$rootScope', '$log', '$http', 'excelService',
    function ($scope, $rootScope, $log, $http, excelService) {

    }]);