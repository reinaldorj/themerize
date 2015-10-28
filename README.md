[![Build Status](https://travis-ci.org/willcrisis/themerize.svg?branch=master)](https://travis-ci.org/willcrisis/themerize)

# Themerize
A Grails plugin that allows you to easily develop themes to your app. 

## 1. Installing
Just add `runtime ":themerize:0.1.0"` to your `BuildConfig`.
If you want to use a different theme than the default one, you can override the plugin's template files (as described below) or install a plugin that contains the template files you want to use and override `grails.themerize.theme` in `Config.groovy` with theme name.

## 2. Using
This plugin contains a series of tags and template files that you can use to customize your application. Let's see which are them.

#### `<thmrz:resources />`
This tag will include the Javascript and CSS resources to your page. It's recommended to use it in your `grails-app/views/layouts/main.gsp` file (or any other layout files you use).

#### `<thmrz:breadcrumbsContainer />`
Renders a container for rendering breadcrumbs. No body is nedded.

#### `<thmrz:breadcrumbs />`
Anything inside it's body will be putted inside `<thmrz:breadcrumbsContainer />`. You must put `<thmrz:breadcrumbItem />` in it's body. 

#### `<thmrz:breadcrumbItem />`
Renders a breadcrumb item for your page. It must be inside `<thmrz:breadcrumbs>` body.

#### `<thmrz:submenu />`
Renders a container which will be used for rendering submenus into your views. You must put `<thmrz:submenuItem>`s tags inside it's body.

#### `<thmrz:submenuItem />`
Renders a submenu item for your page. It must be inside `<thmrz:submenu>` body.

#### `<thmrz:sidebar />`
Renders a container which will be used for rendering sidebars into your views. You must put `<thmrz:sidebarItem>`s tags inside it's body.

#### `<thmrz:sidebarItem />`
Renders a sidebar item for your page. It must be inside `<thmrz:sidebar>` body. 

#### `<thmrz:sortableColumn />`
Renders a sortable column, just like `<g:sortableColumn>`, but stylized. 

#### `<thmrz:paginate />`
Renders a paginate element, just like `<g:paginate>`, but stylized. 

#### `<thmrz:textField />`
Renders a textField element using the style of your current theme. 

#### `<thmrz:textFieldLabel />`
Renders a textField element with label using the style of your current theme. 

#### `<thmrz:textArea />`
Renders a textField element using the style of your current theme. 

#### `<thmrz:textAreaLabel />`
Renders a textArea element with label using the style of your current theme. 

#### `<thmrz:dateField />`
Renders a dateField element using the style of your current theme.   
It uses [Bootstrap Datetimepicker](https://tarruda.github.io/bootstrap-datetimepicker/). You can use it's documentation to make custom date formatting.

#### `<thmrz:dateFieldLabel />`
Renders a dateField element with label using the style of your current theme. 

#### `<thmrz:select />`
Renders a select element using the style of your current theme. 

#### `<thmrz:selectLabel />`
Renders a select element with label using the style of your current theme. 

#### `<thmrz:localeSelect />`
Renders a localeSelect element using the style of your current theme. 

#### `<thmrz:localeSelectLabel />`
Renders a localeSelect element with label using the style of your current theme. 

#### `<thmrz:timeZoneSelect />`
Renders a timeZoneSelect element using the style of your current theme. 

#### `<thmrz:timeZoneSelectLabel />`
Renders a timeZoneSelect element with label using the style of your current theme. 

#### `<thmrz:currencySelect />`
Renders a currencySelect element using the style of your current theme. 

#### `<thmrz:currencySelectLabel />`
Renders a currencySelect element with label using the style of your current theme. 

#### `<thmrz:field />`
Renders a field element using the style of your current theme. 

#### `<thmrz:fieldLabel />`
Renders a field element with label using the style of your current theme. 

#### `<thmrz:fieldValue />`
Renders a readonly value as a text 

#### `<thmrz:fieldValueLabel />`
Renders a readonly value with label as a text

#### `<thmrz:checkBox />`
Renders a checkBox element using the style of your current theme. 

#### `<thmrz:checkBoxLabel />`
Renders a checkBox element with label using the style of your current theme. 

#### `<thmrz:passwordField />`
Renders a passwordField element using the style of your current theme. 

#### `<thmrz:passwordFieldLabel />`
Renders a passwordField element with label using the style of your current theme. 

#### `<thmrz:uploadField />`
Renders a uploadField element using the style of your current theme. 

#### `<thmrz:uploadFieldLabel />`
Renders a uploadField element with label using the style of your current theme. 

#### `<thmrz:submitButton />`
Renders a submit button element using the style of your current theme. 

#### `<thmrz:resetButton />`
Renders a reset button element using the style of your current theme. 

#### `<thmrz:linkButton />`
Renders a link styled like a button using the style of your current theme.

#### `<thmrz:button />`
Renders a simple button element using the style of your current theme.

#### `<thmrz:menuContainer />`
Renders a menu container in the page.

#### `<thmrz:menu />`
Renders a menu in the page. It must be inside `<thmrz:menuContainer />` tag.

#### `<thmrz:menuItem />`
Renders a menu item in the page. It must be inside `<thmrz:menu />` tag.

#### `<thmrz:messages />`
Renders a container for error, alert, success or any ohter kind of messages.

## 3. Default Layout
This plugin contains a default layout that you can use in your pages. To use it, change the `<meta name="layout" content="main">` to `<meta name="layout" content="thmrz">` in your GSPs.  
This layout contains a blank menu container. To populate it, just create a template called `_pageMenus.gsp` inside `grails-app/views/themerize/menus` and put `<thmrz:menu>` and `<thmrz:menuItem>` tags inside it.  

## 4. Customizing
If you want, you can override the template gsps used to render elements. They need to be under `grails-app/views/themerize`. Just create this folder and implement the files as you need. You'll want to implement these files:   
`breadcrumbs/_breadcrumbs.gsp`   
`breadcrumbs/_breadcrumbItem.gsp`   
`buttons/_linkButton.gsp`   
`buttons/_resetButton.gsp`   
`buttons/_submitButton.gsp`   
`fields/_checkBox.gsp`   
`fields/_checkBoxLabel.gsp`   
`fields/_currencySelect.gsp`   
`fields/_currencySelectLabel.gsp`   
`fields/_dateField.gsp`   
`fields/_dateFieldLabel.gsp`   
`fields/_field.gsp`   
`fields/_fieldLabel.gsp`   
`fields/_fieldValue.gsp`   
`fields/_fieldValueLabel.gsp`   
`fields/_localeSelect.gsp`   
`fields/_localeSelectLabel.gsp`   
`fields/_passwordField.gsp`   
`fields/_passwordFieldLabel.gsp`   
`fields/_select.gsp`   
`fields/_selectLabel.gsp`   
`fields/_textArea.gsp`   
`fields/_textAreaLabel.gsp`   
`fields/_textField.gsp`   
`fields/_textFieldLabel.gsp`   
`fields/_timeZoneSelect.gsp`   
`fields/_timeZoneSelectLabel.gsp`   
`fields/_uploadField.gsp`   
`fields/_uploadFieldLabel.gsp`   
`messages/_messages.gsp`   
`paginate/_currentStep.gsp`   
`paginate/_firstStep.gsp`   
`paginate/_lastStep.gsp`   
`paginate/_next.gsp`   
`paginate/_nextDisabled.gsp`   
`paginate/_paginateStep.gsp`   
`paginate/_previous.gsp`   
`paginate/_previousDisabled.gsp`   
`resources/_resources.gsp`   
`sidebar/_sidebar.gsp`   
`sidebar/_sidebarItem.gsp`   
`sortableColumn/_sortableColumn.gsp`   
`submenu/_submenu.gsp`   
`submenu/submenuItem.gsp`   
