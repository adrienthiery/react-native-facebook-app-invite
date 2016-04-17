/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 */

import React, {
  AppRegistry,
  Component,
  TouchableHighlight,
  StyleSheet,
  Text,
  View
} from 'react-native';
import FacebookAppInvite from 'react-native-facebook-app-invite';

class ReactNativeFacebookAppInviteExample extends Component {
  facebookAppInvite = () => {
      FacebookAppInvite.openAppInvite(
          'http://www.thiery.io/appLink',
          'http://www.thiery.io/appLinkImage.png',
          () => { console.log('Unique callback for now.'); }
      );
  }

  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>
          Welcome to React Native!
        </Text>
        <Text style={styles.instructions}>
          To get started, edit index.ios.js
        </Text>
        <Text onPress={this.facebookAppInvite}>
          Press here for App inviting people
        </Text>
        <Text style={styles.instructions}>
          Press Cmd+R to reload,{'\n'}
          Cmd+D or shake for dev menu
        </Text>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});

AppRegistry.registerComponent('ReactNativeFacebookAppInviteExample', () => ReactNativeFacebookAppInviteExample);
