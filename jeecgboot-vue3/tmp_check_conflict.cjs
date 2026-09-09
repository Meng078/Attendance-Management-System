const esbuild = require('esbuild');
const code = `import { apiList } from '../../openapi/OpenApiAuth.api';
const apiList = (params) => { return defHttp.get({ url: '/sys/user/ListAll', params }); }
`;
try {
  esbuild.transformSync(code, { loader: 'ts' });
  console.log('NO-ERROR');
} catch (e) {
  console.log('ERROR:', e.errors && e.errors[0] ? e.errors[0].text : e.message);
}
