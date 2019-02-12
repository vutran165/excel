appExcel.factory('excelService', ['$resource', '$http', '$window', '$q',
    function ($resource, $http, $window, $q) {

        var hostname = $window.location.hostname;
        var port = $window.location.port;
        var rootUrl = 'http://' + hostname + ':' + port;

        var result = {
            Url: rootUrl,
            single: function (data, config, callback) {
                $http.post(rootUrl + '/api/singleFile', data, config).then(callback);
            },
            test: function (data, config, callback) {
                $http.post(rootUrl + '/api/uploadExcelFile', data, config).then(callback);
            },
            upload: function (data, config, callback) {
                $http.post(rootUrl + '/api/upload', data, config).then(callback);
            },
            multiple: function (data, callback, config) {
                $http.post(rootUrl + '/multipeFile', data, config).then(callback);
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
            for (var value of formData.values()) {
                console.log(value); 
             }

        }

        $scope.upload = function () {
            console.log(formData);
            // var config = {
            //     headers 
            // }
            excelService.upload(formData, { 
                transformRequest : angular.identity,
                headers: {
                    'Content-Type': undefined
                } 
            }, function (err) {
                console.log(err);
            });


        }

    }]);



appExcel.controller('singleFileController', ['$scope', '$rootScope', '$log', '$http', 'excelService',
    function ($scope, $rootScope, $log, $http, excelService) {

    }]);

appExcel.controller('multipleFileController', ['$scope', '$rootScope', '$log', '$http', 'excelService',
    function ($scope, $rootScope, $log, $http, excelService) {

    }]);