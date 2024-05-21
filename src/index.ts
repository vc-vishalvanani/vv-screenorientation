import { registerPlugin } from '@capacitor/core';

import type { VVScreenOrientationPlugin } from './definitions';

const VVScreenOrientation = registerPlugin<VVScreenOrientationPlugin>(
  'VVScreenOrientation',
  {
    web: () => import('./web').then(m => new m.VVScreenOrientationWeb()),
  },
);

export * from './definitions';
export { VVScreenOrientation };
