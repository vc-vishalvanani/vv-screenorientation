import { registerPlugin } from '@capacitor/core';

import type { VVScreenOrientationPlugin } from './definitions';

const VVScreenOrientation = registerPlugin<VVScreenOrientationPlugin>(
  'VVScreenOrientation',
);

export * from './definitions';
export { VVScreenOrientation };
