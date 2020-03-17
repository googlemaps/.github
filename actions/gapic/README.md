# Google GAPIC Action

This action generates a pull request for the GAPIC libary. See [googleapis/googleapis](https://github.com/googleapis/googleapis) for more information.

## Inputs

### `target`

**Required** Bazel target for client library tar in [googleapis/googleapis](https://github.com/googleapis/googleapis).

### `github_token`

**Required** Bazel target for client library tar in [googleapis/googleapis](https://github.com/googleapis/googleapis).

### `tar_path`

**Required** Path in tar to extract.

### `tar_strip_components`

**Required** Number of components to strip from tar path.

### `git_name`

Git name for commit.

### `git_email`

Git email for commit.

### `cache_service_account`

Service account json string for Bazel cache.

### `cache_bucket`

Bucket name for Bazel cache.

## Usage

```yaml
uses: googlemaps/actions/gapic@master
  with:
    target: //google/maps/routes/v1:gapic-maps-routes-v1-go
    github_token: ${{ secrets.GITHUB_TOKEN }}
    tar_path: gapic-maps-routes-v1-go/cloud.google.com/go/maps
    tar_strip_components: 4
    cache_service_account: ${{ secrets.SERVICE_ACCOUNT_CACHE }}
```
