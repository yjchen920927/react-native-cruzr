using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace React.Native.Cruzr.RNReactNativeCruzr
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNReactNativeCruzrModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNReactNativeCruzrModule"/>.
        /// </summary>
        internal RNReactNativeCruzrModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNReactNativeCruzr";
            }
        }
    }
}
