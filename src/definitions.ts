export interface VVScreenOrientationPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
