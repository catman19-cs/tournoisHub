// https://nuxt.com/docs/api/configuration/nuxt-config
import Aura from '@primeuix/themes/aura';
export default defineNuxtConfig({
  compatibilityDate: '2024-11-01',
  devtools: { enabled: true },

  modules: [// '@nuxt/eslint',
  // '@nuxt/fonts',
  // '@nuxt/icon',
  // '@nuxt/image',
  // '@nuxt/scripts'
  '@primevue/nuxt-module','@pinia/nuxt'
  ],
  plugins:[
    '~/plugins/pinia.js'
  ],
  primevue: {
    options: {
        theme: {
            preset: Aura,
            options: {
              prefix: 'p',
              darkModeSelector: 'system',
              cssLayer: false
          }
        }
      }
    },


  
});