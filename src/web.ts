import { WebPlugin } from '@capacitor/core';

import type { VVScreenOrientationPlugin } from './definitions';

export class VVScreenOrientationWeb
  extends WebPlugin
  implements VVScreenOrientationPlugin
{
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
