

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.megansList.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.megansList.UserRole'
grails.plugin.springsecurity.authority.className = 'com.megansList.Role'

// for dev use only
//grails.plugin.springsecurity.logout.postOnly = false

grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/user/**',           access: ['ROLE_ADMIN']],
	[pattern: '/userRole/**',       access: ['ROLE_ADMIN']],
	[pattern: '/role/**',           access: ['ROLE_ADMIN']],
	[pattern: '/address/**',        access: ['ROLE_ADMIN']],
	[pattern: '/review/**',         access: ['ROLE_ADMIN']],
	[pattern: '/reviewer/**',       access: ['ROLE_ADMIN']],
	[pattern: '/property/**',       access: ['ROLE_ADMIN']],
	[pattern: '/propertyManager/**', access: ['ROLE_ADMIN']],
	[pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

