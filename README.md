# Themerize
A Grails plugin that allows you to easily develop themes to your app. 

## 1. Installing
Just add `runtime ":themerize:0.1.0"` to your `BuildConfig`.
If you want to use a different theme than the default one, you can override the plugin's template files (as described below) or install a plugin that contains the template files you want to use and override `grails.themerize.theme` in `Config.groovy` with theme name.

## 2. Using
This plugin contains a series of tags and template files that you can use to customize your application. Let's see which are them.

#### `<thmrz:resources />`
This tag will include the Javascript and CSS resources to your page. It's recommended to use it in your `grails-app/views/layouts/main.gsp` file (or any other layout files you use).

#### `<thmrz:breadcrumbs />`
This tag will render a container which will be used for rendering breadcrumbs. You must put `<thmrz:breadcrumbItem>`s tags inside it's body.

#### `<thmrz:breadcrumbItem />`
This tag will render a breadcrumb item for your page. You must put this tag inside `<thmrz:breadcrumbs>` body.

#### `<thmrz:submenu />`
This tag will render a container which will be used for rendering submenus into your views. You must put `<thmrz:submenuItem>`s tags inside it's body.

#### `<thmrz:submenuItem />`
This tag will render a submenu item for your page. You must put this tag inside `<thmrz:submenu>` body.

#### `<thmrz:sidebar />`
This tag will render a container which will be used for rendering sidebars into your views. You must put `<thmrz:sidebarItem>`s tags inside it's body.

#### `<thmrz:sidebarItem />`
This tag will render a sidebar item for your page. You must put this tag inside `<thmrz:sidebar>` body. 

#### `<thmrz:sortableColumn />`
This tag will render a sortable column, just like `<g:sortableColumn>`, but stylized. 

#### `<thmrz:paginate />`
This tag will render a paginate element, just like `<g:paginate>`, but stylized. 

#### `<thmrz:textField />`
This tag will render a textField element using the style of your current theme. 

#### `<thmrz:textFieldLabel />`
This tag will render a textField element with label using the style of your current theme. 

#### `<thmrz:textArea />`
This tag will render a textField element using the style of your current theme. 

### `<thmrz:textAreaLabel />`
This tag will render a textArea element with label using the style of your current theme. 

#### `<thmrz:dateField />`
This tag will render a dateField element using the style of your current theme.
This tag uses [Bootstrap Datetimepicker](https://tarruda.github.io/bootstrap-datetimepicker/). You can use it's documentation to make custom date formatting.

#### `<thmrz:dateFieldLabel />`
This tag will render a dateField element with label using the style of your current theme. 

#### `<thmrz:select />`
This tag will render a select element using the style of your current theme. 

#### `<thmrz:selectLabel />`
This tag will render a select element with label using the style of your current theme. 

#### `<thmrz:localeSelect />`
This tag will render a localeSelect element using the style of your current theme. 

#### `<thmrz:localeSelectLabel />`
This tag will render a localeSelect element with label using the style of your current theme. 

#### `<thmrz:timeZoneSelect />`
This tag will render a timeZoneSelect element using the style of your current theme. 

#### `<thmrz:timeZoneSelectLabel />`
This tag will render a timeZoneSelect element with label using the style of your current theme. 

#### `<thmrz:currencySelect />`
This tag will render a currencySelect element using the style of your current theme. 

#### `<thmrz:currencySelectLabel />`
This tag will render a currencySelect element with label using the style of your current theme. 

#### `<thmrz:field />`
This tag will render a field element using the style of your current theme. 

#### `<thmrz:fieldLabel />`
This tag will render a field element with label using the style of your current theme. 

#### `<thmrz:checkBox />`
This tag will render a checkBox element using the style of your current theme. 

#### `<thmrz:checkBoxLabel />`
This tag will render a checkBox element with label using the style of your current theme. 

#### `<thmrz:passwordField />`
This tag will render a passwordField element using the style of your current theme. 

#### `<thmrz:passwordFieldLabel />`
This tag will render a passwordField element with label using the style of your current theme. 

#### `<thmrz:uploadField />`
This tag will render a uploadField element using the style of your current theme. 

#### `<thmrz:uploadFieldLabel />`
This tag will render a uploadField element with label using the style of your current theme. 

#### `<thmrz:submitButton />`
This tag will render a submit button element using the style of your current theme. 

#### `<thmrz:resetButton />`
This tag will render a reset button element using the style of your current theme. 

#### `<thmrz:linkButton />`
This tag will render a link styled like a button using the style of your current theme.

#### `<thmrz:button />`
This tag will render a simple button element using the style of your current theme.

## 3. Customizing
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
