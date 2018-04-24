$.when($.ready).then(() => {
  const THEME_KEY = 'material-theme';
  const themes = [
    'oceanic',
    'darker',
    'lighter',
    'palenight',
    'onedark',
    'arcdark',
    'monokai',
    'solardark',
    'solarlight',
  ];

  const jekyllApp = {

    setBodyClass(css) {
      const {classList} = document.getElementsByTagName('body')[0];
      classList.remove(...themes);
      classList.add('index', css);
    },
    setTheme(theme) {
      this.setBodyClass(theme.className);
    },
    showMenu() {
      $('.menu').toggleClass('active');
    },
    scrollSpyOn(wrapper, opt) {
      new window.ScrollSpy(wrapper, opt).init();
    },

    toggleSidebar() {
      $('.sidebar').toggleClass('open');
    },

    init() {
      // todo load from local storage
      let theme = localStorage.getItem(THEME_KEY) || 'oceanic';
      this.setBodyClass(theme);

      const $target = $('.doc');
      const $toc = $('.toc');

      if ($toc.length) {
        $toc.pushpin({
          top: 284,
          bottom: $target.offset().top + $target.outerHeight() - $toc.height(),
          offset: 64,
        });
      }

      // custom scroll spy (is that necessary?)
      this.scrollSpyOn('.doc', {nav: '.toc a'});

      this.initMenu();
      this.initThemeChooser();
      this.initSidebar();
      // this.initSearch();
    },

    /**
     * Init Menu events
     */
    initMenu() {
      $('.js-menu-toggle').on('click touch', (event) => {
        this.showMenu();
      });
    },

    /**
     * Init Theme Chooser events
     */
    initThemeChooser() {
      $('.js-theme').on('click touch', (event) => {
        const $el = $(event.target);
        const themeClass = $el.data('themeClass');

        this.setBodyClass(themeClass);
        localStorage.setItem(THEME_KEY, themeClass);
      });
    },

    /**
     * Init Sidebar events
     */
    initSidebar() {
      $('.js-sidebar-toggle').on('click touch', (event) => {
        this.toggleSidebar();
      });
    },

    initSearch() {
      const search = instantsearch({
        // Replace with your own values
        appId: '77GG697EBY',
        apiKey: 'b102643f245ea01e97b9a54047386402', // search only API key, no ADMIN key
        indexName: 'localhost',
        urlSync: true,
      });

      search.addWidget(
        instantsearch.widgets.searchBox({
          container: '#search',
          magnifier: false,
          reset: false,
        }),
      );

      search.addWidget(
        instantsearch.widgets.hits({
          container: '#hits',
          hitsPerPage: 5,
          cssClasses: {
            root: 'search-results-hits',
            empty: 'search-results-empty',
            item: 'search-results-item',
          },
          templates: {
            item: `
              <p>{{{_highlightResult.title.value}}}</p>
              `,
            empty: 'We didn\'t find any results for the search <em>"{{query}}"</em>',
          },
        }),
      );

      search.start();
    },

  };

  // init
  jekyllApp.init();

  window.jekyllApp = jekyllApp;
});

