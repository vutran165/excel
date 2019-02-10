var appExcel = angular.module('appExcel', ['ngMaterial', 'ngResource', 'ui.router']);

appExcel.config(['$windowProvider', '$resourceProvider','$mdThemingProvider' ,'$stateProvider', '$urlRouterProvider', '$httpProvider',
    function ($windowProvider, $resourceProvider, $mdThemingProvider ,$stateProvider, $urlRouterProvider, $httpProvider, ) {

        // config multipart/form-data
        // $httpProvider.defaults.headers.post['Content-Type'] = 'multipart/form-data; charset=utf-8';

        $mdThemingProvider.theme('default')
        .primaryPalette('pink')
        .accentPalette('orange');

        var window = $windowProvider.$get('$window');

        var hostname = window.location.hostname;
        var port = window.location.port;
        var rootUrl = 'http://' + hostname + ':' + port;

        $stateProvider.state('home',
            {
                url: '/home',
                templateUrl: rootUrl + '/assets/index-app.html',
                controller: 'uploadFileController'
            })


        $urlRouterProvider.otherwise('/home');

    }]);