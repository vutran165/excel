appExcel.directive('ngFiles', ['$parse', function ($parse) {
    function fn_link(scope, element, attrs) {
        var onChange = $parse(attrs.ngFiles);
        element.on('change', function (eve) {
            onChange(scope, { $files: eve.target.files });
        })
    };

    return {link: fn_link};
}]);

// appExcel.directive()
