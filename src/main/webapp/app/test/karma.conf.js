module.exports = function(config) {
    config.set({

        basePath: '../',

        files: [
            'test/spec/**/*.js'
        ],

        autoWatch: false,
        singleRun: true,

        frameworks: ['jasmine'],

        browsers: ['Chrome'],

        plugins: [
            'karma-chrome-launcher',
            'karma-jasmine'
        ],

    });
};
