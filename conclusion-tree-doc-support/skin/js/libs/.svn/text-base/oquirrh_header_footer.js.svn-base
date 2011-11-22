var options = {};
var url_map = {'home':'https://www.familysearch.org',
               'cdn':'https://cdn.familysearch.org/content',
               'content':'www.familysearch.org',
               'logout':'https://www.familysearch.org/content/index/logout',
               'help':'https://www.familysearch.org/help',
               'oAuthEndpoint':'https://https://www.familysearch.org/content/oauth/auth?return_controller=index&return_action=oauthComplete&error_controller=index&error_action=oauthComplete'
                       + '&consumer=' + escape(options.oAuthConsumer)
                       + '&returnUrl=' + escape(document.location),
               'cis':''};
var header_string='<header id="site-nav" class="clearfix">  <nav id="primary-nav">    <ul class="clearfix">      <li class="brand-link"><a id="brand" href="https://www.familysearch.org" title="FamilySearch - Home">FamilySearch - Home</a></li>      <li class="tree-link hide"><a onclick="s_gi(\'ldsglobal\').tl(this,\'o\',\'home:TreeLink\');" href="https://www.familysearch.org/tree/" title="">Family Tree</a></li>      <li class="learn-link"><a href="https://www.familysearch.org/learn" title="Family history articles, classes, videos and guides for genealogy research">Learn</a></li>      <li class="locations-link"><a href="https://www.familysearch.org/locations" title="Get personal help. See hours, locations, events and resources for local FamilySearch Centers">FamilySearch Centers</a></li>      <li class="contribute-link"><a href="https://www.familysearch.org/volunteer/indexing" title="Every person matters. Help us in our efforts to input names from historical documents">Indexing</a></li>      <li class="general-link"><a href="https://www.familysearch.org/blog" title="Current insights into family history">Blog</a></li>    </ul>  </nav>  <nav id="secondary-nav">    <ul class="clearfix">      <li style="display:none" id="settings-link"><a title="View and modify your profile settings" href="https://ident.familysearch.org/cis-web/pages/profile/changeProfile.html">Settings</a></li>      <li><a id="help-link" title="Product Support, Forums, Frequently Asked Questions, and more" href="https://www.familysearch.org/help">Help</a></li>      <li style="display:none" id="logout-link"><a title="Logout of your FamilySearch Account" href="https://www.familysearch.org/content/index/logout">Sign Out</a></li>      <li><a id="sign-in-link" title="Make use of features only available to registered users" href="https://www.familysearch.org/content/oauth/auth?return_controller=index&return_action=oauthComplete&error_controller=index&error_action=oauthComplete&consumer=www&returnUrl=" onclick="this.href=this.href+encodeURIComponent(document.location)">Sign In</a></li>    </ul>  </nav></header>';
var feedback_link = '<a target="_blank" href="https://www.familysearch.org/help/feedback" id="showfeedback" class="global-feedback" title="Feedback">Feedback</a>';
var footer_string = '  <div id="page-footer-nav" class="clearfix">    <div id="page-footer-decor"><div class="decor i"></div><div class="decor ii"></div></div>    <div id="page-footer-learn" class="clearfix">      <h1 class="h6">Learn</h1>      <ul class="footer-col1">        <li><a href="https://www.familysearch.org/learn/whats_new">What&rsquo;s New</a></li>        <li><a href="https://www.familysearch.org/learn/getting_started">Getting Started</a></li>        <li><a href="https://www.familysearch.org/learn/researchcourses">Free Courses</a></li>      </ul>      <ul class="footer-col2">        <li><a href="https://wiki.familysearch.org/en/Browse_by_Country">Browse Articles</a></li>        <li><a href="https://www.familysearch.org/volunteer/indexing">Indexing</a></li>      </ul>    </div>    <div id="page-footer-general" class="clearfix">      <h1 class="h6">General</h1>      <ul class="footer-col3">        <li><a href="https://www.familysearch.org/about">About Us</a></li>        <li><a href="https://www.familysearch.org/volunteer">Give Back</a></li>        <li><a href="https://www.familysearch.org/careers">Careers</a></li>      </ul>      <ul class="footer-col4">        <li><a href="https://www.familysearch.org/blog">Blog</a></li>        <li><a href="https://www.familysearch.org/news">Press</a></li>        <li><a target="_blank" href="https://labs.familysearch.org">Labs</a></li>        <!--li><a href="https://secure3.convio.net/ldsp/site/Donation2?df_id=2981&2981.donation=form1">Donate</a></li-->      </ul>      <ul  class="footer-col5">        <li><a href="https://store.familysearch.org">Store</a></li>        <li><a href="https://www.familysearch.org/privacy">Privacy</a></li>        <li><a href="https://www.familysearch.org/terms">Terms</a></li>      </ul>    </div>    <div id="page-footer-resources" class="clearfix">      <h1 class="h6">Resources</h1>      <ul class="footer-col6">        <li><a href="https://www.familysearch.org/help/self-help">Ask for Help</a></li>        <li><a target="_blank" href="http://www.gensocietyofutah.org">Archivists</a></li>        <li><a target="_blank" href="https://devnet.familysearch.org">Developers</a></li>      </ul>      <ul class="footer-col7">        <li><a href="https://www.familysearch.org/locations/centerlocator">Libraries</a></li>        <li><a href="https://www.familysearch.org/products">Products</a></li>        <li><a target="_blank" href="https://www.familysearch.org/help/feedback">Feedback</a></li>      </ul>    </div>    <p><span>&copy; 2011 IRI</span>&nbsp;A service provided by&nbsp;<a href="http://mormon.org" target="_blank">The Church of Jesus Christ of Latter-day Saints</a>. &nbsp; <span class="call-link"><a target="_blank" href="http://www.familysearch.org/eng/default.asp">Use the previous version of FamilySearch.org</a></span></p>  </div>  <div class="decor iv"></div><div class="decor v"></div><div class="decor vi"></div><div class="decor vii"></div><div class="decor viii"></div><div class="decor ix"></div><div class="decor x"></div><div class="decor xi"></div>';
jQuery('#header').ready(function() {
  jQuery('#header').html(header_string);
});

jQuery('#page-footer').ready(function() {
  jQuery('#page-footer').html(footer_string);
});

jQuery('body').ready(function (){
  jQuery('body').append(feedback_link);
});

function validateSession(sessionId) {
  jQuery.getJSON("https://www.familysearch.org/content/cis/validateSession?callback=?", function(data){
    if (data.valid) {
      jQuery('#header').html(header_string);
      jQuery('#page-footer').html(footer_string);
      jQuery('#settings-link').show();
      jQuery('#sign-in-link').hide();
      jQuery('#logout-link').show();
      renderDisplayName();
      jQuery.getJSON("https://www.familysearch.org/search/permission/check/FamilyTree-FsbetaTreeViewPermission?callback=?", function(data){
        if (data == true) {
          jQuery('.tree-link').show();
        } else {
          jQuery('.tree-link').hide();
        }
      });
    }
    else {
      deleteCookie('fssessionid', '/', 'familysearch.org');
      deleteCookie('displayName', '/', 'familysearch.org');
      jQuery('#header').html(header_string);/* re-render the header to its original (not logged in) state */
    }
  });
}

function renderDisplayName() {
  var displayNameCookie = getCookie('displayName');
  var displayName = "";
  if(displayNameCookie!=null) {
    displayName = decodeURI(displayNameCookie.replace(/(^[\"]+|[\"]+$)/g, '').replace(new RegExp("\\+","g"),'%20'));
    sendOmnitureAccountData();
  }
  if(displayName==="") {
    jQuery.getJSON("https://www.familysearch.org/content/index/displayName?callback=?", function(data){
      var displayName = decodeURI(data.displayName.replace(/(^[\"]+|[\"]+$)/g, '').replace(new RegExp("\\+","g"),'%20'));
      var displayNameLi = jQuery('#cis-displayName');
      if(!displayNameLi || displayNameLi.length<1) {
        jQuery('#secondary-nav ul').prepend('<li id="cis-displayName">'+displayName+'</li>');
      }
      else {
        displayNameLi.html(displayName);
      }
    });
  }
  else {
    jQuery('#secondary-nav ul').prepend('<li id="cis-displayName">'+displayName+'</li>');
  }
}

jQuery('#sign-in-link').ready(function() {
  var sessionId = getCookie('fssessionid');
  if (sessionId !== null && sessionId != "null" && sessionId != "") {
    validateSession(sessionId);
  }
});

var sendOmnitureAccountData = function() {
  var omnitureAccountDataCookie = getCookie('scaccinfo');
  if (omnitureAccountDataCookie != null) {
    if (omnitureAccountDataCookie === '1') {
      s.prop40='Member';
      s.eVar40='Member';
    }
    else {
      s.prop40='Public';
      s.eVar40='Public';
    }
    s.prop46='FamilySearch Account';
    s.eVar46='FamilySearch Account';
    deleteCookie('scaccinfo', '/', 'familysearch.org');
    var s_code = s.t({pageName:'Sign In: FS Account'});
    if (s_code) {
      document.write(s_code);
    }
  }
}

var getCookie = function(name) {
  var cookieValue = null;
  if (document.cookie && document.cookie != '') {
      var cookies = document.cookie.split(';');
      for (var i = 0; i < cookies.length; i++) {
          var cookie = jQuery.trim(cookies[i]);
          if (cookie.substring(0, name.length + 1) == (name + '=')) {
              cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
              break;
          }
      }
  }
  return cookieValue;
}

var setCookie = function(name, value, options) {
	var val = value==null?value:encodeURIComponent(value);
	var expires = '; expires=' + new Date(new Date() + options.expires*1000).toUTCString(); //expects secs
	var path = options.path ? '; path=' + (options.path) : '';
	var domain = options.domain ? '; domain=' + (options.domain) : '';
	var secure = options.secure ? '; secure' : '';
	document.cookie = name + '=' + val + expires + path + domain + secure;
}

var deleteCookie = function ( name, path, domain ) {
  if ( getCookie( name ) ) {
    document.cookie = name + "=" +
        ( ( path ) ? ";path=" + path : "") +
        ( ( domain ) ? ";domain=" + domain : "" ) +
        ";expires=Thu, 01-Jan-1970 00:00:01 GMT";
  }
}
